package game2048.services;

import game2048.exceptions.InvalidMoveException;

public interface GameService {
    void initialise();
    void start();
    void makeMove() throws InvalidMoveException;
    void restart();
    boolean isGameOver();
    boolean isWinner();
}
