package tictactoe.errors;

public class InvalidPositionException extends Exception{
    public InvalidPositionException() {
    }

    public InvalidPositionException(String message) {
        super(message);
    }
}
