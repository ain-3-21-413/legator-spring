package kg.inai.legator.entity.patron;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatronPatronGroup {
    Patron patron;
    PatronGroup patronGroup;
}
