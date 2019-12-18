package io.trabe.teaching.rest.model.pojo.api.external.common;

import io.trabe.teaching.rest.model.pojo.OperationKind;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ApiOperationCommand {
	
	private Double amount;
	private OperationKind kind;
	private Long destination;
}
