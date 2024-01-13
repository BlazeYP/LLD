package tictactoe.serviceImpl;

import tictactoe.model.Piece;
import tictactoe.model.Player;
import tictactoe.model.Position;
import tictactoe.service.BoardService;
import tictactoe.service.GameService;

import java.util.*;

public class GameServiceImpl implements GameService {

    private List<Player> playerList;
    private BoardService boardService;
    private Deque<Player> playerDeque;
    private Piece winnerPiece;

    public GameServiceImpl(List<Player> playerList, BoardService boardService) {
        this.playerList = playerList;
        this.boardService = boardService;
    }

    @Override
    public void initialise() {
        this.boardService.initialise();
        this.playerDeque = new ArrayDeque<>();
        for(Player p : this.playerList){
            this.playerDeque.addLast(p);
        }
    }

    @Override
    public void start() {
        //Print the initial board
        System.out.println("Game started!");
        this.boardService.printBoard();
    }

    @Override
    public void restart() {
        //Reset board
        this.boardService.reset();
        //Reset player Deque
        this.playerDeque = new ArrayDeque<>();
        for(Player p : this.playerList){
            this.playerDeque.addLast(p);
        }
        this.start();
    }

    @Override
    public void showTurn() {
        System.out.println(this.playerDeque.peek().getName() +"'s chance:");
    }

    @Override
    public void makeMove(Position position) throws Exception{
        Player playingPlayer = this.playerDeque.peek();
        this.boardService.addPiece(position,playingPlayer.getPlayingPiece());
        this.boardService.printBoard();
        playerDeque.removeFirst();
        playerDeque.addLast(playingPlayer);
    }

    @Override
    public boolean isOver() {
        int boardSize = this.boardService.getBoardSize(), row, col;
        try {
            //Checking rows
            for (row = 0; row < boardSize; row++) {
                // Getting First piece of each row
                Piece firstPiece = this.boardService.getPiece(new Position(row, 0));
                for (col = 0; col < boardSize; col++) {
                    Piece piece = this.boardService.getPiece(new Position(row, col));
                    if (piece == null || firstPiece != piece) {
                        break;
                    }
                }
                if (col == boardSize) {
                    this.winnerPiece = firstPiece;
                    return true;
                }
            }

            //Checking cols
            for (col = 0; col < boardSize; col++) {
                // Getting First piece of each col
                Piece firstPiece = this.boardService.getPiece(new Position(0, col));
                for (row = 0; row < boardSize; row++) {
                    Piece piece = this.boardService.getPiece(new Position(row, col));
                    if (piece == null || firstPiece != piece) {
                        break;
                    }
                }
                if (row == boardSize) {
                    this.winnerPiece = firstPiece;
                    return true;
                }
            }

            //Checking Left Diagonal
            Piece firstPiece = this.boardService.getPiece(new Position(0, 0));
            for (row = 0; row < boardSize; row++) {
                Piece piece = this.boardService.getPiece(new Position(row, row));
                if (piece == null || firstPiece != piece) {
                    break;
                }
            }
            if (row == boardSize) {
                this.winnerPiece = firstPiece;
                return true;
            }

            //Checking Right Diagonal
            for (row = 0; row < boardSize; row++) {
                Piece piece = this.boardService.getPiece(new Position(row, boardSize - row - 1));
                if (piece == null || firstPiece != piece) {
                    break;
                }
            }
            if (row == boardSize) {
                this.winnerPiece = firstPiece;
                return true;
            }
        } catch (Exception e){

        }
        //Checking for tie
        return this.boardService.isBoardFull();
    }

    @Override
    public Player getWinner() {
        for(Player p : this.playerList){
            if(p.getPlayingPiece().equals(this.winnerPiece)){
                return p;
            }
        }
        return null;
    }
}
