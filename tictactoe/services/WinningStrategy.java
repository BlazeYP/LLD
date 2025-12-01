package tictactoe.services;

import tictactoe.models.Piece;

public interface WinningStrategy {
    Piece hasWon();
}
