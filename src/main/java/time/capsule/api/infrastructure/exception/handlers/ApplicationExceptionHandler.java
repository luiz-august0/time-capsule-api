package time.capsule.api.infrastructure.exception.handlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import time.capsule.api.infrastructure.exception.classes.ErrorBody;
import time.capsule.api.infrastructure.exception.exceptions.ApplicationGenericsException;
import time.capsule.api.infrastructure.exception.exceptions.ValidatorException;
import time.capsule.api.core.util.DateUtil;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationGenericsException.class)
    public ResponseEntity<ErrorBody> handler(ApplicationGenericsException e, HttpServletRequest request) {
        String error = e.getClass().getName();
        HttpStatus status = e.getStatus();
        ErrorBody err = new ErrorBody(DateUtil.getDate(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<ErrorBody> handler(ValidatorException e, HttpServletRequest request) {
        String error = e.getClass().getName();
        HttpStatus status = e.getStatus();
        ErrorBody err = new ErrorBody(DateUtil.getDate(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}