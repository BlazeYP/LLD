package tictactoe.exceptions;

public class AlreadyOccupiedException extends Exception{
    public AlreadyOccupiedException() {
    }

    public AlreadyOccupiedException(String message) {
        super(message);
    }
}
