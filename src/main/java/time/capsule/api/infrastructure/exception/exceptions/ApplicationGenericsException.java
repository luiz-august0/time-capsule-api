package time.capsule.api.infrastructure.exception.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationGenericsException extends RuntimeException {

    private final HttpStatus status;

    public ApplicationGenericsException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
    }

}
