package tictactoe.service;

import tictactoe.exceptions.AlreadyOccupiedException;
import tictactoe.exceptions.InvalidPositionException;
import tictactoe.model.Piece;
import tictactoe.model.Position;

public interface BoardService {
    void initialise();
    void addPiece(Position position, Piece piece) throws AlreadyOccupiedException, InvalidPositionException;
    void printBoard();
    void reset();
    int getBoardSize();
    Piece getPiece(Position p) throws InvalidPositionException;
    boolean isBoardFull();
}
