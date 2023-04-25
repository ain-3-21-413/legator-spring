package kg.inai.legator.entity.patron;

import kg.inai.legator.entity.User;
import kg.inai.legator.entity.item.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Patron {
    String number;
    String firstName;
    String lastName;
    String middleName;
    String phone;
    String email;
    AccessLevel accessLevel;
    User user;
}
