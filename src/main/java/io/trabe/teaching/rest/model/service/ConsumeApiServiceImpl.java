package io.trabe.teaching.rest.model.service;

import java.util.List;

import org.springframework.stereotype.Component;

import io.trabe.teaching.rest.model.accessor.publicapi.PublicapiAccessor;
import io.trabe.teaching.rest.model.pojo.Account;

@Component
public class ConsumeApiServiceImpl implements ConsumeApiService {

    private final PublicapiAccessor publicapiAccessor;

    public ConsumeApiServiceImpl(PublicapiAccessor publicapiAccessor) {
        this.publicapiAccessor = publicapiAccessor;
    }

    @Override
    public List<Account> getAccountsByUserLogin(String userLogin) {
        return publicapiAccessor.getUserAccounts(userLogin);
    }

    @Override
    public Account createAccount(String userLogin, Account account) {
        return publicapiAccessor.createAccount(userLogin, account);
    }
}
