package tictactoe.services;

import tictactoe.models.Player;
import tictactoe.models.Position;

public interface GameService {
    void initialise();
    void start();
    void restart();
    void showTurn();
    void makeMove(Position position) throws Exception;
    boolean isOver();
    Player getWinner();
}
