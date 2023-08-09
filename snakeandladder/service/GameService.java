package snakeandladder.service;

import snakeandladder.models.Player;

import java.util.List;

public interface GameService {
    void initialise();
    void start();
    List<Player> getWinners();
}
