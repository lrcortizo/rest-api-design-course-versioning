package io.trabe.teaching.rest.model.pojo.api.external.common;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ApiUser {
	private Long id;
	private String name;
	private String login;
	private List<ApiAccount> accounts;
}
