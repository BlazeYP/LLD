package tictactoe;

import tictactoe.exceptions.InputParseException;
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
import java.util.StringTokenizer;

public class Main {
    private static int noOfPlayers;
    private static Scanner scanner = new Scanner(System.in);

    private static List<Player> getPlayerDetails(){
        System.out.print("Enter the number of players, max number of player is 5: ");
        noOfPlayers = Math.min(scanner.nextInt(),5);
        scanner.nextLine();

        List<Player> playerList = new ArrayList<>();

        for(int count=1; count<=noOfPlayers; count++){
            System.out.print("Enter "+ count + " player name: ");
            Player p = new Player(scanner.nextLine(), Piece.values()[count-1]);
            playerList.add(p);
        }
        return playerList;
    }

    private static Position parseInputToPosition(String s) throws InputParseException {
        StringTokenizer tokenizer = new StringTokenizer(s, ",");
        if(tokenizer.countTokens() != 2 ){
            throw new InputParseException("ERROR | Wrong Input provided, try again!");
        }
        int x = Integer.parseInt(tokenizer.nextToken().trim());
        int y = Integer.parseInt(tokenizer.nextToken().trim());
        return new Position(x,y);
    }

    public static void main(String[] args) {
        //Get the details of players
        List<Player> playerList = getPlayerDetails();

        //Get board size
        System.out.print("Enter playing board size: ");
        int boardSize = scanner.nextInt();
        scanner.nextLine();
        Board board = new Board(boardSize);

        //Initialise services
        BoardService boardService = new BoardServiceImpl(board);
        GameService gameService = new GameServiceImpl(playerList, boardService);

        //Starting game
        gameService.initialise();
        gameService.start();

        while(true){
            gameService.showTurn();
            System.out.println("Enter the position as x,y or write 'restart': ");
            String s = scanner.nextLine();
            if(Constants.RESTART.equals(s)){
                gameService.restart();
                continue;
            }
            try {
                Position position = parseInputToPosition(s);
                gameService.makeMove(position);
                if(gameService.isOver()){
                    break;
                }
            }
            catch( Exception e){
                System.out.println(e.getMessage());
            }
        }
        Player p = gameService.getWinner();
        if(p != null) {
            System.out.printf("%s wins!", p.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}