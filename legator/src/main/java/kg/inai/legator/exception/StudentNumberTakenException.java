package kg.inai.legator.exception;

public class StudentNumberTakenException extends RuntimeException {

    public StudentNumberTakenException(String studentNumber) {
        super(studentNumber + " is taken.");
    }
}
