package io.trabe.teaching.rest.model.service;

import java.nio.charset.Charset;
import java.security.interfaces.RSAPublicKey;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class CosumeTokenServiceImpl implements CosumeTokenService {

	@Override
	public String generateToken() {

		String token_viejo = "eyJhbGciOiJSUzI1NiIsImtpZCI6InB1YmxpYzpjNDI0YjY3Yi1mZTI4LTQ1ZDctYjAxNS1mNzlkYTUwYjViMjEiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOltdLCJjbGllbnRfaWQiOiJteS1jbGllbnQiLCJleHAiOjE1NzY3NzM3NTYsImV4dCI6e30sImlhdCI6MTU3Njc3MDE1NiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo0NDQ0LyIsImp0aSI6IjI2MmQxOTkxLTQ3ZDAtNDYwZC1hYzk4LTRiMTgzNTM1NjllZiIsIm5iZiI6MTU3Njc3MDE1Niwic2NwIjpbXSwic3ViIjoibXktY2xpZW50In0.hc7tJPa1oqfZ2FzDdTafS7l-OR58spcHy47wk6uRxbqp8TPICYQyYGGcK-pWneXdqq9I8fhrgZq9kYfuS-eLC2D85Zav4WHN-sq_8LEaRBhWO5DVRBb2R9sGRfSLtFn1L4ZAtlktaPIqboDoaprdfp8jc0xAufKqkTgru5Vs0jMk0j-8HYrIYdbJ5ohIkWGsthNMm_JvZfaU6fCbLrKxImnNWh0WPQXTMimjD17-XPuWRr8jHU5QYjGvJG6thw9uCRLDaoUTQxSOloFV5TPhbnbL6rhkr1c9CI9pIUEEMIcbdyA0gbIW_sdio8Hr4C0FSI1Dk-zAtxCj4seJCWSZEiFJJey44svwisUc1dcPiYcjw4JYhDg7a0mnCntZZt0DHrcNjVE07UXRQ_bK9aUpxJZwyms8U2ax7y9g0Zfr4EoutZ9dmCr2iBnlfsJajPYd-S0_1RPvYH6T_51v3JbEhzlJn7aXoryPjaHg45AhSHAvNvCSlQBRZ7Is4AvRzZxLcuputHC4nIeekytzzxafHPfGUXKJOwVNpITPiER-_col3nNUyNyysniwrhKnLEwNHTRx5qRRjMFwFTCpFwlIDamHx5BtgPizQtXurc1638o0E0gaRDsGVhlYDOObcY6QGHwpvxOMhp0TKvsZwijvLgUA-xAQtHLMI-KTeePY064";
	
		try {
			DecodedJWT jwt = JWT.decode(token_viejo);
			JwkProvider provider = new UrlJwkProvider("http://localhost:4444");
			Jwk jwk = provider.get(jwt.getKeyId());
			Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
			algorithm.verify(jwt);
		} catch(Exception e) {
			RestTemplate restTemplate = new RestTemplate();
			GrantType grant = new GrantType();
			grant.setGrant_type("client_credentials");
			HttpEntity<GrantType> entity = new HttpEntity<>(grant, createHeaders());
			try {
			String token_nuevo = restTemplate.exchange("http://192.168.43.119:4444/oauth2/token",
					HttpMethod.POST, entity, String.class).getBody();
			return token_nuevo;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return token_viejo;
	}

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();

		String auth = "my-client:secret";
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);

		headers.set("Content-Type", "application/x-www-form-urlencoded");

		return headers;
	}

}
