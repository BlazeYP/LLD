package snakeandladder.serviceImpl;


import snakeandladder.models.Board;
import snakeandladder.models.Ladder;
import snakeandladder.models.Snake;
import snakeandladder.service.BoardService;

import java.util.*;

public class BoardServiceImplManual implements BoardService {
    private Board board;
    private Scanner scanner;
    private Map<Integer, Integer> snakeLadderGraph;
    

    public BoardServiceImplManual(Board board) {
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
        System.out.println("Enter snake positions: ");
        List<Snake> snakeList = new ArrayList<>(snakeCount);
        for(int count=0; count<snakeCount; count++ ){
            int start = this.scanner.nextInt();
            int end = this.scanner.nextInt();
            Snake snake = new Snake(start, end);
            snakeList.set(count, snake);
        }

        return snakeList;
    }

    private List<Ladder> getLadders(){
        System.out.println("Enter ladder count: ");
        int ladderCount = this.scanner.nextInt();
        System.out.println("Enter ladder positions: ");
        List<Ladder> ladderList = new ArrayList<>(ladderCount);
        for(int count=0; count<ladderCount; count++ ){
            int start = this.scanner.nextInt();
            int end = this.scanner.nextInt();
            Ladder ladder = new Ladder(start, end);
            ladderList.set(count, ladder);
        }

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
        
        // Initialising the snakeLadderGraph
        this.initialiseSnakeLadderGraph(snakeList, ladderList);
    }

    private void initialiseSnakeLadderGraph(List<Snake> snakeList, List<Ladder> ladderList) {
        this.snakeLadderGraph = new HashMap<>();
        for(Snake snake: snakeList){
            this.snakeLadderGraph.put(snake.getStart(), snake.getEnd());
        }
        for(Ladder ladder : ladderList){
            this.snakeLadderGraph.put(ladder.getStart(), ladder.getEnd());
        }
    }


    @Override
    public int getSize() {
        return this.board.getSize();
    }

    @Override
    public int getFinalPosition(int position) {
        while(this.snakeLadderGraph.containsKey(position)){
            position = this.snakeLadderGraph.get(position);
        }
        return position;
    }
}
