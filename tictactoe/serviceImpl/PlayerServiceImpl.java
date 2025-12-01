package tictactoe.serviceImpl;

import tictactoe.models.Piece;
import tictactoe.models.Player;
import tictactoe.models.Position;
import tictactoe.services.PlayerService;

import java.util.ArrayDeque;
import java.util.Queue;

public class PlayerServiceImpl implements PlayerService {
    private Queue<Player> playerList;

    public PlayerServiceImpl() {
        playerList = new ArrayDeque<>();
    }

    @Override
    public void addPlayer(Player player) {
        playerList.add(player);
    }

    @Override
    public void switchToNextPlayer() {
        Player currentPlayer = playerList.poll();
        playerList.add(currentPlayer);
    }

    @Override
    public Player getCurrentPlayer() {
        return playerList.peek();
    }

    @Override
    public Position getMove(Player player) {
        return player.getMove();
    }

    @Override
    public Player getPlayerFromPiece(Piece piece) {
        for(Player p : playerList) {
            if(piece.equals(p.getPlayingPiece())) {
                return p;
            }
        }
        return null;
    }
}
