//package kg.inai.legator.entity;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Setter
//@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
//public class PatronGroup {
//
//    @Id
//    String name;
//
//    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<Patron> patrons = new ArrayList<>();
//
//    public PatronGroup(String name) {
//        this.name = name;
//    }
//
//    public void addPatron(Patron patron) {
//        patrons.add(patron);
//        patron.setGroup(this);
//    }
//
//    public void removePatron(Patron patron) {
//        patrons.remove(patron);
//        patron.setGroup(null);
//    }
//}
