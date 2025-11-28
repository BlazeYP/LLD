package tictactoe;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TicTacToeGame {
    private List<Player> playerList;
    private Board board;
    private Queue<Player> playerQueue;
    private Piece winnerPiece;
    private Scanner sc;

    public TicTacToeGame(List<Player> playerList, Board board) {
        this.playerList = playerList;
        this.board = board;
        sc = new Scanner(System.in);
    }

    private void printBoard() {
        int size = board.getSize();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(board.getGrid()[i][j] == null) System.out.print(" _ ");
                else System.out.print(" " +board.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isGameOver() {
        int size = board.getSize(), row, col;
        //Check for rows
        for(row=0; row<size; row++) {
            for(col=0; col<size; col++) {
                if(board.getGrid()[row][0] == null || board.getGrid()[row][0] != board.getGrid()[row][col])
                    break;
            }
            if(col == size) {
                winnerPiece = board.getGrid()[row][0];
                return true;
            }
        }

        //Check for cols
        for(col=0; col<size; col++) {
            for(row=0; row<size; row++) {
                if(board.getGrid()[0][col]== null || board.getGrid()[0][col] != board.getGrid()[row][col])
                    break;
            }
            if(row == size) {
                winnerPiece = board.getGrid()[0][col];
                return true;
            }
        }

        //Check for diagonal
        for(row=0; row<size; row++) {
            if(board.getGrid()[0][0]== null || board.getGrid()[0][0] != board.getGrid()[row][row])
                break;
        }
        if(row == size) {
            winnerPiece = board.getGrid()[0][0];
            return true;
        }

        //Check for anti-diagonal
        for(row=0; row<size; row++) {
            if(board.getGrid()[0][size-1] == null || board.getGrid()[0][size-1] != board.getGrid()[row][size-1-row])
                break;
        }
        if(row == size) {
            winnerPiece = board.getGrid()[0][size-1];
            return true;
        }

        //Check for full occupancy
        for(row=0; row<size; row++) {
            for(col=0; col<size; col++) {
                if (board.getGrid()[row][col] == null) return false;
            }
        }
        return true;
    }

    private boolean isMoveValid(int x, int y) {
        int size = board.getSize();
        return x>=0 && x<size && y>=0 && y<size && board.getGrid()[x][y] == null;
    }

    public void play() {
        playerQueue = new ArrayDeque<>(playerList);
        printBoard();
        while(!isGameOver()) {
            //Get move/position
            System.out.println("Enter move:");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(isMoveValid(x,y)) {
                Player currentPlayer = playerQueue.poll();
                board.getGrid()[x][y] = currentPlayer.getPlayingPiece();
                playerQueue.add(currentPlayer);
                printBoard();
            } else {
                System.out.println("Invalid move, try again: ");
            }
        }
        if(winnerPiece == null) {
            System.out.println("Game draw");
        } else {
            for(Player player : playerList) {
                if(player.getPlayingPiece() == winnerPiece) {
                    System.out.println(player.getName() + " is winner!!");
                    return;
                }
            }
        }
    }
}
