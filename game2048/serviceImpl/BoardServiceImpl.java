package game2048.serviceImpl;

import game2048.models.Board;
import game2048.models.Position;
import game2048.services.BoardService;
import game2048.services.RandomPositionGeneratorService;
import game2048.utilities.Constants;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BoardServiceImpl implements BoardService {
    private Board board;

    private int boardSize;
    private Set<Position> occupiedPositions;
    private RandomPositionGeneratorService randomPositionGeneratorService;

    public BoardServiceImpl(Board board) {
        this.board = board;
        this.boardSize = board.getSize();
    }

    @Override
    public void initialise() {
        // Initialising empty set as occupied positions
        this.occupiedPositions = new HashSet<>();
        // Initialising 2 empty positions with base number;
        Position p1 = this.randomPositionGeneratorService.generateRandomPosition(boardSize, boardSize, occupiedPositions);
        board.getGrid()[p1.getX()][p1.getY()] = Constants.BASE_NUMBER;
        this.occupiedPositions.add(p1);
        Position p2 = this.randomPositionGeneratorService.generateRandomPosition(boardSize, boardSize, occupiedPositions);
        board.getGrid()[p2.getX()][p2.getY()] = Constants.BASE_NUMBER;
        this.occupiedPositions.add(p2);
    }

    @Override
    public void printBoard() {
        System.out.println();
        for(int row=0; row<boardSize; row++){
            for(int col=0; col<boardSize; col++){
                if(Objects.nonNull(this.board.getGrid()[row][col])){
                    System.out.print(Constants.SEPARATOR + this.board.getGrid()[row][col] + Constants.SEPARATOR);
                } else {
                    System.out.print(Constants.SEPARATOR + Constants.EMPTY_CELL_SIGNIFIER + Constants.SEPARATOR);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void reset() {
        int size = this.board.getSize();
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++) {
                this.board.getGrid()[row][col] = null;
            }
        }
        this.initialise();
    }

    @Override
    public void moveToLeft() {

    }

    @Override
    public void moveToRight() {

    }

    @Override
    public void moveToTop() {

    }

    @Override
    public void moveToBottom() {

    }

    @Override
    public boolean isBoardFull() {
        return false;
    }
}
