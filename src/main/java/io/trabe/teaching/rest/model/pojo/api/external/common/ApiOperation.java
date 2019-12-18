package io.trabe.teaching.rest.model.pojo.api.external.common;

import java.time.LocalDateTime;

import io.trabe.teaching.rest.model.pojo.OperationKind;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ApiOperation {
	
	private Long id;
	private OperationKind kind;
	private ApiPaymentMethod paymentMethod;
	private LocalDateTime date;
    private String description;
    private Double amount;
}
