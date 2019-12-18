package io.trabe.teaching.rest.model.pojo.api.external.common;

import java.time.LocalDateTime;

import io.trabe.teaching.rest.model.pojo.OperationKind;
import io.trabe.teaching.rest.model.pojo.PaymentMethod;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiOperationCreationRequest {
	
	private OperationKind kind;
	private PaymentMethod paymentMethod;
	private LocalDateTime date;
    private String description;
    private Double amount;
}
