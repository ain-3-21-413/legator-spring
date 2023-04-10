package kg.inai.legator.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import kg.inai.legator.entity.User;
import kg.inai.legator.jwt.JwtService;
import kg.inai.legator.mapper.UserMapper;
import kg.inai.legator.model.auth.LoginRequest;
import kg.inai.legator.model.auth.LoginResponse;
import kg.inai.legator.service.AuthService;
import kg.inai.legator.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService  {

	private final AuthenticationManager authenticationManager;
	private final UserService userService;
	private final JwtService jwtService;
	private final UserMapper userMapper;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
				loginRequest.username(), 
				loginRequest.password()
			)
		);
		User user = userService.getUserByUsername(loginRequest.username());
		String jwt = jwtService.generateToken(user);
		return new LoginResponse(jwt, userMapper.toModel(user));
	}

}
