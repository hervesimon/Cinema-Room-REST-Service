package cinema.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AlreadyPurchasedException.class, UnsupportedPurchaseException.class, InvalidTokenException.class})
    public ResponseEntity<Error> handleCommonException(
            Exception ex, WebRequest request) {
        Error error = new Error(ex.getMessage());
        return new ResponseEntity<Error>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotAuthorizedException.class})
    public ResponseEntity<Error> handleNotAuthorizedExceptionException(
            Exception ex, WebRequest request) {
        Error error = new Error(ex.getMessage());
        return new ResponseEntity<Error>(error, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    public class Error {
        public Error(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        private String error;


    }
}
