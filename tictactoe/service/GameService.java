package tictactoe.service;

import tictactoe.model.Player;
import tictactoe.model.Position;

public interface GameService {
    void initialise();
    void start();
    void restart();
    void makeMove(Position position);
    boolean isOver();
    Player getWinner();
}
