package tdd.locker;

public class ErrorMessageException extends Exception {
    public ErrorMessageException(String errorMessage) {
        super(errorMessage);
    }
}