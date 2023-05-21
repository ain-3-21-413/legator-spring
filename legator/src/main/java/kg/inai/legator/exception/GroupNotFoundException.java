package kg.inai.legator.exception;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(String groupName) {
        super("Group " + groupName + " not found.");
    }
}
