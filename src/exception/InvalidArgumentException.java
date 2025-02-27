package exception;

@SuppressWarnings("serial")
public class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String message) {
        System.err.println("\nERROR: " + message);
    }
}

