package kg.inai.legator.entity.patron;

import jakarta.persistence.*;
import kg.inai.legator.entity.User;
import kg.inai.legator.entity.item.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Patron {

    @Id
    String number;
    
    String firstName;
    
    String lastName;
    
    String middleName;
    
    String phone;
    
    String email;
    
    @Enumerated(EnumType.STRING)
    AccessLevel accessLevel;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
}
