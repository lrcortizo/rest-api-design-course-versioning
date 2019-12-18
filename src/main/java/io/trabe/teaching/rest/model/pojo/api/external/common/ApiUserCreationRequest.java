package io.trabe.teaching.rest.model.pojo.api.external.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiUserCreationRequest {
	private String name;
	private String login;
}
