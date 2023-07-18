package tictactoe.service;

import tictactoe.model.Player;
import tictactoe.model.Position;

public interface GameService {
    void initialise();
    void start();
    void restart();
    void showTurn();
    void makeMove(Position position) throws Exception;
    boolean isOver();
    Player getWinner();
}
