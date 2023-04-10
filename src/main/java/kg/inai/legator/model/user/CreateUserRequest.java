package kg.inai.legator.model.user;

public record CreateUserRequest(
	String username,
	String password,
	String role
) {

}
