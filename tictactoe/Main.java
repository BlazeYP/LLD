package tictactoe;

import tictactoe.model.Board;
import tictactoe.model.Piece;
import tictactoe.model.Player;
import tictactoe.model.Position;
import tictactoe.service.BoardService;
import tictactoe.service.GameService;
import tictactoe.serviceImpl.BoardServiceImpl;
import tictactoe.serviceImpl.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int noOfPlayers;
    private static Scanner scanner = new Scanner(System.in);

    private static List<Player> getPlayerDetails(){
        System.out.print("Enter the number of players, max number of player is 5: ");
        noOfPlayers = Math.min(scanner.nextInt(),5);

        List<Player> playerList = new ArrayList<>();

        for(int count=0; count<noOfPlayers; count++){
            System.out.print("Enter "+ count + "player name: ");
            Player p = new Player(scanner.nextLine(), Piece.values()[count]);
            playerList.add(p);
        }
        return playerList;
    }

    private static Position parseInputToPosition(String s){
        return null;
    }

    public static void main(String[] args) {
        //Get the details of players
        List<Player> playerList = getPlayerDetails();

        //Get board size
        int boardSize = scanner.nextInt();
        Board board = new Board(boardSize);

        //Initialise services
        BoardService boardService = new BoardServiceImpl(board);
        GameService gameService = new GameServiceImpl(board, playerList, boardService);

        //Starting game
        gameService.initialise();
        gameService.start();

        while(!gameService.isOver()){
            System.out.println("Enter the position as x,y or write 'restart': ");
            String s = scanner.nextLine();
            if(Constants.RESTART.equals(s)){
                gameService.restart();
            }
            Position position = parseInputToPosition(s);
            gameService.makeMove(position);
        }

        System.out.printf("Winner is player %s!", gameService.getWinner().getName());
    }
}