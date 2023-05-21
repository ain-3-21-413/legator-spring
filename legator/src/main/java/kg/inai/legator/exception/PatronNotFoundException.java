package kg.inai.legator.exception;

public class PatronNotFoundException extends RuntimeException {

    public PatronNotFoundException(String studentNumber) {
        super(studentNumber);
    }
}
