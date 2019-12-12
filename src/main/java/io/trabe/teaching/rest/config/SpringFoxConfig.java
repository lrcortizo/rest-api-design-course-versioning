package io.trabe.teaching.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket v1Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api-v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.trabe.teaching.rest.controller.rest"))
                .paths(PathSelectors.ant("/api/public/1/**"))
                .build();
    }

    @Bean
    public Docket v2Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api-v2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.trabe.teaching.rest.controller.rest"))
                .paths(PathSelectors.ant("/api/public/2/**"))
                .build();
    }

}
