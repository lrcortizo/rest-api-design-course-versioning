package io.trabe.teaching.rest.model.pojo.api.external.common;

import io.trabe.teaching.rest.model.pojo.PaymentMethodKind;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ApiPaymentMethod {
	
	private Long id;
    private String alias;
    private PaymentMethodKind kind;
}
