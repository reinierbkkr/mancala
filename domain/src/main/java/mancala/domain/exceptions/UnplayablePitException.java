package mancala.domain.exceptions;

public class UnplayablePitException extends Exception {
    public UnplayablePitException() {
        super("Pit is not playable.");
    }

    public UnplayablePitException(String message) {
        super(message);
    }

    public UnplayablePitException(String message, Throwable cause) {
        super(message, cause);
    }
}