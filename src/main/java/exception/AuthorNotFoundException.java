package exception;

public class AuthorNotFoundException extends Exception {

    public AuthorNotFoundException() {

    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

    public AuthorNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorNotFoundException(String message,Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFoundException(String message, Throwable cause, boolean writableStackTrace, boolean enableSuppression) {
        super(message,cause,writableStackTrace,enableSuppression);
    }
}
