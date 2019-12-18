package io.trabe.teaching.rest.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.trabe.teaching.rest.model.pojo.api.external.common.ApiAccount;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiOperation;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiPaymentMethod;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiUser;
import io.trabe.teaching.rest.model.pojo.Account;
import io.trabe.teaching.rest.model.pojo.Operation;
import io.trabe.teaching.rest.model.pojo.PaymentMethod;
import io.trabe.teaching.rest.model.pojo.User;
import io.trabe.teaching.rest.model.pojo.api.external.v2.ApiExtendedAccount;

@Mapper(componentModel = "spring")
public interface ExternalApiMapper {

    ApiAccount toAccountApi(Account account);

    List<ApiAccount> toAccountApiList(List<Account> accounts);

    @Mapping(target = "extendedInformation", constant = "Some extended information")
    ApiExtendedAccount toExtendedAccountApi(Account account);
    
    ApiUser toUserApi(User user);
    
    List<ApiUser> toUserApiList(List<User> users);
    
    ApiOperation toOperationApi(Operation operation);

	List<ApiOperation> toOperationApiList(List<Operation> operations);
	
	ApiPaymentMethod toPaymentMethodApi(PaymentMethod paymentMethod);
	
	List<ApiPaymentMethod> toPaymentMethodApiList(List<PaymentMethod> paymentMethods);
}
