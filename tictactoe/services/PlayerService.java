package tictactoe.services;

import tictactoe.models.Piece;
import tictactoe.models.Player;
import tictactoe.models.Position;

public interface PlayerService {
    void addPlayer(Player player);
    void switchToNextPlayer();
    Player getCurrentPlayer();
    Position getMove(Player player);
    Player getPlayerFromPiece(Piece piece);
}
