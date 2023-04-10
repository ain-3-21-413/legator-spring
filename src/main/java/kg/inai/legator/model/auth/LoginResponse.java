package kg.inai.legator.model.auth;

import kg.inai.legator.model.user.UserModel;

public record LoginResponse(
	String jwt,
	UserModel user
) {

}
