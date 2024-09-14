package UN.Sanad.Handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleActivityNotFoundException(EntityNotFoundException e){
        EntityException entityException=new EntityException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(entityException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = EntityAlreadyExist.class)
    public ResponseEntity<Object> handleEntityAlreadyExistException(EntityAlreadyExist e){
        EntityAlreadyExistException entityException2=new EntityAlreadyExistException(
                e.getMessage(),
                e.getCause(),
                HttpStatus.FOUND

        );
        return new ResponseEntity<>(entityException2, HttpStatus.FOUND);
    }
}
