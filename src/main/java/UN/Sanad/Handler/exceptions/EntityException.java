package UN.Sanad.Handler.exceptions;

import org.springframework.http.HttpStatus;

public record EntityException(String message, Throwable throwable, HttpStatus httpStatus) {
}
