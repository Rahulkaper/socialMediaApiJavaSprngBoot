package Rahul.Devs.restfulwebservices.exception;
import Rahul.Devs.restfulwebservices.User.UserNotFound;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> HandleAllExceptions(Exception ex, WebRequest request ){
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new  ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Object> HandleUserNotFoundExc(Exception ex, WebRequest request ){
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new  ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

   
}
