package io.trabe.teaching.rest.controller.rest.external.v2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.trabe.teaching.rest.controller.mapper.ExternalApiMapper;
import io.trabe.teaching.rest.controller.rest.external.ExternalApiV2;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiUser;
import io.trabe.teaching.rest.model.pojo.api.external.common.ApiUserCreationRequest;
import io.trabe.teaching.rest.model.service.UserService;

@ExternalApiV2
@RestController
public class UserApiV2Controller {
	
	private final UserService userService;
    private final ExternalApiMapper externalApiMapper;
	
    public UserApiV2Controller(UserService userService, ExternalApiMapper externalApiMapper) {
    	this.userService = userService;
        this.externalApiMapper = externalApiMapper;
    }
    
    @GetMapping("/users")
    public List<ApiUser> getUsers() {
    	return externalApiMapper.toUserApiList(userService.getAllUsers());
    }
    
    @GetMapping("/users/{userId}")
    public ApiUser getUser(@PathVariable Long userId) {
    	return externalApiMapper.toUserApi(userService.getUser(userId).get());
    }
    
    @PostMapping(value = "/users", consumes = "application/json")
    @ApiOperation("Creación de usuarios")
    public ApiUser createUser(@RequestBody ApiUserCreationRequest userRequest) {
    	return externalApiMapper.toUserApi(userService.createUser(userRequest.getLogin(), userRequest.getName()));
    }
    
    @PatchMapping(value = "/users", consumes = "application/json")
    public void updateUser(@RequestBody ApiUserCreationRequest userRequest) {
    	userService.updateUser(userRequest.getLogin(), userRequest.getName());
    }

}
