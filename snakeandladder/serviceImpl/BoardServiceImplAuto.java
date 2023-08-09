package snakeandladder.serviceImpl;

import snakeandladder.models.Board;
import snakeandladder.models.Ladder;
import snakeandladder.models.Snake;
import snakeandladder.service.BoardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardServiceImplAuto implements BoardService {
    private Board board;
    private Scanner scanner;

    public BoardServiceImplAuto(Board board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }

    private int getBoardSize(){
        System.out.print("Enter the board size: ");
        int boardSize = this.scanner.nextInt();
        return boardSize;
    }

    private List<Snake> getSnakes(){
        System.out.print("Enter snake count: ");
        int snakeCount = this.scanner.nextInt();
        List<Snake> snakeList = new ArrayList<>(snakeCount);

        return snakeList;
    }

    private List<Ladder> getLadders(){
        System.out.println("Enter ladder count: ");
        int ladderCount = this.scanner.nextInt();

        List<Ladder> ladderList = new ArrayList<>(ladderCount);

        return ladderList;
    }

    @Override
    public void initialise() {
        // Getting all elements
        int boardSize = this.getBoardSize();
        List<Snake> snakeList = this.getSnakes();
        List<Ladder> ladderList = this.getLadders();

        // Setting all elements
        this.board.setSize(boardSize);
        this.board.setSnakesList(snakeList);
        this.board.setLadderList(ladderList);
    }


    @Override
    public int getSize() {
        return this.board.getSize();
    }

    @Override
    public int getFinalPosition(int position) {
        return 0;
    }
}
