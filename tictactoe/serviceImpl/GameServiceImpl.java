package tictactoe.serviceImpl;

import tictactoe.model.Board;
import tictactoe.model.Player;
import tictactoe.model.Position;
import tictactoe.service.BoardService;
import tictactoe.service.GameService;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class GameServiceImpl implements GameService {

    private List<Player> playerList;
    private BoardService boardService;
    private Deque<Player> playerDeque;

    public GameServiceImpl(List<Player> playerList, BoardService boardService) {
        this.playerList = playerList;
        this.boardService = boardService;
    }

    @Override
    public void initialise() {
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
        this.boardService.resetBoard();
        //Reset player Deque
        this.playerDeque.clear();
    }

    @Override
    public void makeMove(Position position) {
        Player playingPlayer = this.playerDeque.peek();
        if(boardService.addPiece(position,playingPlayer.getPlayingPiece())){
            playerDeque.removeFirst();
            playerDeque.addLast(playingPlayer);
            System.out.println(this.playerDeque.peek().getName() +"'s chance:");
        }
        else{
            System.out.println("Invalid move!");
            System.out.println(this.playerDeque.peek().getName() +"'s chance again:");
        }

    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public Player getWinner() {
        return null;
    }
}
