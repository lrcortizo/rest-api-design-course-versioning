package io.trabe.teaching.rest.controller.rest.examples;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.trabe.teaching.rest.model.pojo.Account;
import io.trabe.teaching.rest.model.service.ConsumeApiService;
import io.trabe.teaching.rest.model.service.CosumeTokenService;

@RestController
@RequestMapping("/api/examples/1/consume-accounts/users")
public class ConsumeApiController {

    private final ConsumeApiService consumeApiService;
    
    private CosumeTokenService consumeTokenService;


    public ConsumeApiController(ConsumeApiService consumeApiService, CosumeTokenService consumeTokenService) {
        this.consumeApiService = consumeApiService;
        this.consumeTokenService = consumeTokenService;
    }

    @GetMapping(value = "/{userId}/accounts")
    public List<Account> userAccounts(@PathVariable String userId) {
    	consumeTokenService.generateToken();
    	
        return consumeApiService.getAccountsByUserLogin(userId);
    }
    
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long id) {
    	consumeApiService.deleteUser(id);
    }
}
