package tictactoe.service;

import tictactoe.model.Piece;
import tictactoe.model.Position;

public interface BoardService {
    void initialise();
    void addPiece(Position position, Piece piece) throws Exception;
    void printBoard();
    void resetBoard();
    int getBoardSize();
    Piece getPiece(Position p) throws Exception;
    boolean isBoardFull();
}
