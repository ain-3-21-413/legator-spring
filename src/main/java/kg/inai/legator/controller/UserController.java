package kg.inai.legator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kg.inai.legator.model.user.CreateUserRequest;
import kg.inai.legator.model.user.UserModel;
import kg.inai.legator.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

	private final UserService service;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public UserModel createUser(@RequestBody CreateUserRequest createUserRequest) {
		return service.createUser(createUserRequest);
	}
}
