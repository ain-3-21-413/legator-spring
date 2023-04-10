package kg.inai.legator.mapper;

import org.springframework.stereotype.Component;

import kg.inai.legator.entity.User;
import kg.inai.legator.enums.ERole;
import kg.inai.legator.exception.RoleNotFoundException;
import kg.inai.legator.model.user.CreateUserRequest;
import kg.inai.legator.model.user.UserModel;

@Component
public class UserMapper implements Mapper<User, UserModel> {

	@Override
	public UserModel toModel(User entity) {
		return new UserModel(entity.getId(), entity.getUsername(), entity.getRole().name());
	}

	@Override
	public User toEntity(UserModel model) {
		User user = User.builder().id(model.id()).username(model.username()).build();
		if (model.role().equals("LIBRARIAN")) {
			user.setRole(ERole.LIBRARIAN);
		} else if (model.role().equals("PATRON")) {
			user.setRole(ERole.PATRON);
		} else {
			throw new RoleNotFoundException("Role : " + model.role() + " : not found.");
		}
		return user;
	}

	public User toEntity(CreateUserRequest createUserRequest) {
		User user = User.builder().username(createUserRequest.username()).build();
		if (createUserRequest.role().equals("LIBRARIAN")) {
			user.setRole(ERole.LIBRARIAN);
		} else if (createUserRequest.role().equals("PATRON")) {
			user.setRole(ERole.PATRON);
		} else {
			throw new RoleNotFoundException("Role : " + createUserRequest.role() + " : not found.");
		}
		return user;
	}
	
}