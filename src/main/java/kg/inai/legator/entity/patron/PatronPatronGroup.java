package kg.inai.legator.entity.patron;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.parameters.P;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatronPatronGroup {
    Patron patron;
    PatronGroup patronGroup;
}
