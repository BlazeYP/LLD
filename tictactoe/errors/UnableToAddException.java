package tictactoe.errors;

public class UnableToAddException extends Exception{
    public UnableToAddException() {
    }

    public UnableToAddException(String message) {
        super(message);
    }
}
