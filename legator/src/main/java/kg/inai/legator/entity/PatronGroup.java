package kg.inai.legator.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PatronGroup {

    @Id
    String name;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Patron> patrons = new ArrayList<>();
}
