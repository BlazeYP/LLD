package tictactoe.serviceImpl;

import tictactoe.models.Piece;
import tictactoe.models.Player;
import tictactoe.models.Position;
import tictactoe.services.*;

import java.util.Objects;

public class GameServiceImpl implements GameService {
    private BoardService boardService;
    private PlayerService playerService;
    private WinningStrategy winningStrategy;
    private Piece winningPiece;

    public GameServiceImpl() {
        initialise();
    }

    private void initialise() {
        GameInitialiser gameInitialiser = new GameInitialiserImpl();
        gameInitialiser.initialise();
        this.boardService = gameInitialiser.getBoardService();
        this.playerService = gameInitialiser.getPlayerService();
        this.winningStrategy = gameInitialiser.getWinningStrategy();
    }

    private boolean isGameOver() {
        winningPiece = winningStrategy.hasWon();
        return Objects.nonNull(winningPiece) || boardService.isBoardFull();
    }

    @Override
    public void start() {
        boardService.printBoard();
        while(!isGameOver()) {
            Player currentPlayer = playerService.getCurrentPlayer();
            Position p = playerService.getMove(currentPlayer);
            try {
                boardService.addPiece(p, currentPlayer.getPlayingPiece());
                boardService.printBoard();
                playerService.switchToNextPlayer();
            } catch (Exception e) {
                System.out.println("Invalid Move, try again!");
            }
        }
        if(Objects.nonNull(winningPiece)) {
            System.out.println(playerService.getPlayerFromPiece(winningPiece).getName() + " has won!!!");
        } else {
            System.out.println("It's a draw!!");
        }
    }
}
