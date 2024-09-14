package UN.Sanad.Handler.exceptions;

import org.springframework.http.HttpStatus;

public record EntityAlreadyExistException(String message,Throwable throwable,HttpStatus httpStatus) {
}
