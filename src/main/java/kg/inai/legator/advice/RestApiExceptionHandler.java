package kg.inai.legator.advice;

import java.util.Date;

import kg.inai.legator.exception.PatronGroupNameTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import kg.inai.legator.exception.RoleNotFoundException;
import kg.inai.legator.exception.UserNotFoundException;
import kg.inai.legator.exception.UsernameTakenException;
import kg.inai.legator.model.ErrorMessage;


@RestControllerAdvice
public class RestApiExceptionHandler {


    @ExceptionHandler({UserNotFoundException.class, RoleNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundException(Exception exception, WebRequest request) {
        return new ErrorMessage(
                exception.getMessage(),
                new Date()
        );
    }

    @ExceptionHandler({UsernameTakenException.class, PatronGroupNameTakenException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage usernameTakenException(Exception exception, WebRequest request) {
        return new ErrorMessage(
                exception.getMessage(),
                new Date()
        );
    }
}
