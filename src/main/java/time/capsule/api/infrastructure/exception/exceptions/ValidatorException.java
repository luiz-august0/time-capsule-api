package time.capsule.api.infrastructure.exception.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidatorException extends RuntimeException {

    private final HttpStatus status;

    public ValidatorException(String message) {
        super(message);
        this.status = HttpStatus.UNAUTHORIZED;
    }

}
