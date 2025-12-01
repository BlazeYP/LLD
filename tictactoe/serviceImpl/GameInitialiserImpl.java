package tictactoe.serviceImpl;

import tictactoe.models.Board;
import tictactoe.models.Piece;
import tictactoe.models.Player;
import tictactoe.services.BoardService;
import tictactoe.services.GameInitialiser;
import tictactoe.services.PlayerService;
import tictactoe.services.WinningStrategy;

import java.util.Scanner;

public class GameInitialiserImpl implements GameInitialiser {
    private BoardService boardService;
    private PlayerService playerService;
    private WinningStrategy winningStrategy;
    private Scanner sc;

    public GameInitialiserImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void initialise() {
        //Get Board details
        System.out.print("Enter board size: ");
        int size = sc.nextInt();
        sc.nextLine();
        Board board = new Board(size);
        this.boardService = new BoardServiceImpl(board);
        //Get player details
        System.out.println("Enter first player name, who takes X: ");
        Player player1 = new Player(sc.nextLine(), Piece.X);
        System.out.println("Enter second player name, who takes O: ");
        Player player2 = new Player(sc.nextLine(), Piece.O);
        this.playerService = new PlayerServiceImpl();
        playerService.addPlayer(player1);
        playerService.addPlayer(player2);
        //Setting winning strategy
        winningStrategy = new AllCheckWinningStrategyImpl(boardService);
    }

    @Override
    public BoardService getBoardService() {
        return boardService;
    }

    @Override
    public PlayerService getPlayerService() {
        return playerService;
    }

    @Override
    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }
}
