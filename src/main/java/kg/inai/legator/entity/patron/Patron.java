package kg.inai.legator.entity.patron;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_level_id")
    AccessLevel accessLevel;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
}
