package kg.inai.legator.exception;

public class PatronGroupNotFoundException extends RuntimeException {
    public PatronGroupNotFoundException(String patronGroupName) {
        super("Group " + patronGroupName + " not found.");
    }
}
