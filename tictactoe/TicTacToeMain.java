package tictactoe;

import tictactoe.serviceImpl.GameServiceImpl;
import tictactoe.services.GameService;

public class TicTacToeMain {
    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        gameService.start();
    }
}
