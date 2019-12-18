package io.trabe.teaching.rest.controller.rest.external.v2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.trabe.teaching.rest.controller.mapper.ExternalApiMapper;
import io.trabe.teaching.rest.controller.rest.external.ExternalApiV2;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiOperation;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiOperationCommand;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiOperationCreationRequest;
import io.trabe.teaching.rest.model.service.AccountService;

@RestController
@ExternalApiV2
public class OperationApiV2Controller {

	private final AccountService accountService;
	private final ExternalApiMapper externalApiMapper;

	public OperationApiV2Controller(AccountService accountService, ExternalApiMapper externalApiMapper) {
		super();
		this.accountService = accountService;
		this.externalApiMapper = externalApiMapper;
	}

	@GetMapping(value = "/users/{userId}/accounts/{accountId}/operations")
	public List<ApiOperation> getOperations(@PathVariable long accountId,
			@RequestParam(required = false, value="paymentMethod") String paymentMethod) {
		return externalApiMapper.toOperationApiList(accountService.getAccountOperations(accountId));
	}

	@PostMapping("/users/{userId}/accounts/operations")
	public ApiOperation createOperation(@RequestBody ApiOperationCommand operationRequest) {
		return externalApiMapper.toOperationApi(accountService.createOperation(operationRequest.getDestination(),
				null, operationRequest.getAmount(), null));
	}
}
