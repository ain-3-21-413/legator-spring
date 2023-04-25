package kg.inai.legator.entity.patron;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatronGroup {
    int id;
    String name;
    int checkedOutDuration;
    int holdDuration;
    int renewedDuration;
    int checkedOutCount;
    int holdCount;
    int renewsAllowedCount;
}
