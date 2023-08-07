package tictactoe.exceptions;

public class UnableToAddException extends Exception{
    public UnableToAddException() {
    }

    public UnableToAddException(String message) {
        super(message);
    }
}
