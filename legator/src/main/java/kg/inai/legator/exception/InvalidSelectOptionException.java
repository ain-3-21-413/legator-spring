package kg.inai.legator.exception;

public class InvalidSelectOptionException extends RuntimeException{

    public InvalidSelectOptionException() {
        super("Select option is invalid");
    }
}
