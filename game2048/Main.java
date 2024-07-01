package game2048;

import game2048.exceptions.InvalidMoveException;
import game2048.models.Board;
import game2048.serviceImpl.BoardServiceImpl;
import game2048.serviceImpl.GameServiceImpl;
import game2048.serviceImpl.RandomPositionGeneratorServiceImpl;
import game2048.services.BoardService;
import game2048.services.GameService;
import game2048.services.RandomPositionGeneratorService;
import game2048.utilities.Constants;

public class Main {
    public static void main(String[] args){
        //Initialising Board
        Board board = new Board(Constants.BOARD_SIZE);
        //Initialising RandomPositionGeneratorService
        RandomPositionGeneratorService randomPositionGeneratorService = RandomPositionGeneratorServiceImpl.getInstance();
        //Initialising BoardService
        BoardService boardService = new BoardServiceImpl(board, randomPositionGeneratorService);
        //Initialising GameService
        GameService gameService = new GameServiceImpl(boardService);

        //Starting the game
        gameService.initialise();
        gameService.start();

        while(!gameService.isGameOver()){
            try {
                gameService.makeMove();
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
        }

        if(gameService.isWinner()) {
            System.out.println("Congratulations!!");
        } else {
            System.out.println("Better luck next time!!");
        }

    }
}
