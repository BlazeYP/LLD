package tictactoe.services;

import tictactoe.exceptions.AlreadyOccupiedException;
import tictactoe.exceptions.InvalidPositionException;
import tictactoe.models.Piece;
import tictactoe.models.Position;

public interface BoardService {
    void initialise();
    void addPiece(Position position, Piece piece) throws AlreadyOccupiedException, InvalidPositionException;
    void printBoard();
    void reset();
    int getBoardSize();
    Piece getPiece(Position p) throws InvalidPositionException;
    boolean isBoardFull();
}
