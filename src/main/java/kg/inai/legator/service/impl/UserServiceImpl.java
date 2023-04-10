package kg.inai.legator.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kg.inai.legator.entity.User;
import kg.inai.legator.exception.UserNotFoundException;
import kg.inai.legator.exception.UsernameTakenException;
import kg.inai.legator.mapper.UserMapper;
import kg.inai.legator.model.user.CreateUserRequest;
import kg.inai.legator.model.user.UserModel;
import kg.inai.legator.repository.UserRepository;
import kg.inai.legator.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final UserMapper mapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserModel createUser(CreateUserRequest createUserRequest) {
		if (repository.existsByUsername(createUserRequest.username())) {
			throw new UsernameTakenException("Username : " + createUserRequest.username() + " : is taken.");
		}
		User user = mapper.toEntity(createUserRequest);
		user.setPassword(passwordEncoder.encode(createUserRequest.password()));
		return mapper.toModel(repository.save(user));
	}

	@Override
	public User getUserByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User : " + username + " : not found."));
	}
}
