package kg.inai.legator.model;

import kg.inai.legator.model.user.CreateUserRequest;

public record PatronModel(
    String number,
	String firstName,
    String lastName,
    String middleName,
    String phone,
    String email,
    int accessLevel,
    CreateUserRequest user
) {

}
