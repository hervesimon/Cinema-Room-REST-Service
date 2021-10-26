package cinema.exception;

public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException() {
        super("The password is wrong!");
    }
}
