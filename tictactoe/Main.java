package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter first players:");
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("Y", Piece.X);
        System.out.println("Enter second players:");
        Player player2 = new Player("S", Piece.O);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);

        System.out.println("Enter size of board:");
        Board board = new Board(sc.nextInt());

        TicTacToeGame game = new TicTacToeGame(playerList, board);
        game.play();
    }
}