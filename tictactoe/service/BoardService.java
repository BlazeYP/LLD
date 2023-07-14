package tictactoe.service;

import tictactoe.model.Piece;
import tictactoe.model.Position;

public interface BoardService {
    boolean addPiece(Position position, Piece piece);
    void printBoard();
    void resetBoard();
}
