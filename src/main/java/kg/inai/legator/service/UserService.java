package kg.inai.legator.service;

import kg.inai.legator.entity.User;
import kg.inai.legator.model.user.CreateUserRequest;
import kg.inai.legator.model.user.UserModel;

public interface UserService {

	UserModel createUser(CreateUserRequest createUserRequest);

	User getUserByUsername(String username);
}
