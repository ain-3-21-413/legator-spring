package kg.inai.legator.advice;

import kg.inai.legator.dto.ErrorMessage;
import kg.inai.legator.exception.GroupNotFoundException;
import kg.inai.legator.exception.InvalidSelectOptionException;
import kg.inai.legator.exception.StudentNumberTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    // TODO: add exception handlers

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({GroupNotFoundException.class, InvalidSelectOptionException.class, GroupNotFoundException.class, StudentNumberTakenException.class})
    public ErrorMessage groupNotFoundExceptionHandler(Exception exception) {
        return new ErrorMessage(exception.getMessage());
    }
}
