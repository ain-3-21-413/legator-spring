package kg.inai.legator.entity.patron;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PatronGroup {

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    int id;

    String name;
    
    int checkedOutDuration;
    
    int holdDuration;
    
    int renewedDuration;
    
    int checkedOutCount;
    
    int holdCount;
    
    int renewsAllowedCount;
}
