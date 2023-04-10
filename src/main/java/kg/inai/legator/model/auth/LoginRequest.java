package kg.inai.legator.model.auth;

public record LoginRequest(
	String username,
	String password
) {

}
