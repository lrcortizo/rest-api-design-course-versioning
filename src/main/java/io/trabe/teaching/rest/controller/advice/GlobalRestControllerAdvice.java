package io.trabe.teaching.rest.controller.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "io.trabe.teaching.rest.controller.rest")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalRestControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorInformation handleExceptions(Throwable t) {
        return new ErrorInformation(t.getClass().getSimpleName());
    }

}
