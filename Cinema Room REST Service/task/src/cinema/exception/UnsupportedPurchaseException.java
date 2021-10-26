package cinema.exception;

public class UnsupportedPurchaseException extends RuntimeException {

    public UnsupportedPurchaseException() {
        super("The number of a row or a column is out of bounds!");
    }
}
