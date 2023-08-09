package snakeandladder.serviceImpl;

import snakeandladder.models.Player;
import snakeandladder.service.BoardService;
import snakeandladder.service.Dice;
import snakeandladder.service.GameService;

import java.util.*;

public class GameServiceImpl implements GameService {
    private Deque<Player> playerList;
    private BoardService boardService;
    private List<Dice> diceList;
    private Player winnerPlayer;

    public GameServiceImpl(Deque<Player> playerList, BoardService boardService, List<Dice> diceList) {
        this.playerList = playerList;
        this.boardService = boardService;
        this.diceList = diceList;
    }

    @Override
    public void initialise() {
        this.boardService.initialise();
    }


    @Override
    public void start() {
        System.out.println("Game Started!");
        while(true){
            Player currentPlayer = playerList.peek();
            int jumpSize = this.getJumpSize();
            int nextPosition = this.boardService.getFinalPosition(currentPlayer.getPosition() + jumpSize);
            //Print the move
            System.out.printf("\n%s rolled a %s and moved from %s to %s\n", currentPlayer.getName(), jumpSize, currentPlayer.getPosition(), nextPosition);
            currentPlayer.setPosition(nextPosition);
            // Check if game is over
            if(isGameOver(currentPlayer)){
                break;
            }
            playerList.removeFirst();
            playerList.addLast(currentPlayer);
        }
    }

    private boolean isGameOver(Player currentPlayer) {
        if(currentPlayer.getPosition() == this.boardService.getSize()){
            this.winnerPlayer = currentPlayer;
            return true;
        }
        return false;
    }

    @Override
    public List<Player> getWinners() {
        List<Player> winnerList = new ArrayList<>();
        winnerList.add(this.winnerPlayer);
        return winnerList;
    }

    private int getJumpSize(){
        int jumpSize = 0;
        for(Dice dice : diceList){
            jumpSize += dice.roll();
        }
        return jumpSize;
    }
}
