package game2048.serviceImpl;

import game2048.models.Board;
import game2048.models.Position;
import game2048.services.BoardService;
import game2048.services.RandomPositionGeneratorService;
import game2048.utilities.Constants;

import java.util.*;

public class BoardServiceImpl implements BoardService {
    private Board board;

    private int boardSize;
    private List<Position> emptyPositions;
    private RandomPositionGeneratorService randomPositionGeneratorService;

    public BoardServiceImpl(Board board, RandomPositionGeneratorService randomPositionGeneratorService) {
        this.board = board;
        this.randomPositionGeneratorService = randomPositionGeneratorService;
        this.boardSize = board.getSize();
    }

    @Override
    public void initialise() {
        // Initialising board with two tiles
        this.insertTile();
        this.insertTile();
    }

    @Override
    public void printBoard() {
        System.out.println();
        for(int row=0; row<this.boardSize; row++){
            for(int col=0; col<this.boardSize; col++){
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
        for(int row=0; row<this.boardSize; row++){
            for(int col=0; col<this.boardSize; col++) {
                this.board.getGrid()[row][col] = null;
            }
        }
    }

    @Override
    public void insertTile() {
        this.emptyPositions = getEmptyPositions();
        Position p = this.randomPositionGeneratorService.generateRandomPosition(this.emptyPositions);
        this.board.getGrid()[p.getX()][p.getY()] = Constants.BASE_NUMBER;
        this.emptyPositions.remove(p);
    }

    private List<Position> getEmptyPositions() {
        List<Position> emptyPositions = new ArrayList<>();
        for(int row=0; row<this.boardSize; row++){
            for(int col=0; col<this.boardSize; col++) {
                if(Objects.isNull(this.board.getGrid()[row][col])){
                    Position p = new Position(row, col);
                    emptyPositions.add(p);
                }
            }
        }
        return emptyPositions;
    }

    @Override
    public void moveToLeft() {
        for(int row=0; row<this.boardSize; row++){
            int filledIndex = -1;
            boolean isMergedCell = false;
            for(int col=0; col<this.boardSize; col++) {
                if(Objects.nonNull(this.board.getGrid()[row][col])){
                    if(filledIndex != -1 && !isMergedCell && this.board.getGrid()[row][col] == this.board.getGrid()[row][filledIndex]) {
                        this.board.getGrid()[row][filledIndex] *=2;
                        isMergedCell = true;
                    } else {
                        filledIndex++;
                        isMergedCell = false;
                        this.board.getGrid()[row][filledIndex] = this.board.getGrid()[row][col];
                    }
                }
            }
            while(filledIndex < this.boardSize-1){
                this.board.getGrid()[row][++filledIndex] = null;
            }
        }
    }

    @Override
    public void moveToRight() {
        for(int row=0; row<this.boardSize; row++){
            int filledIndex = this.boardSize;
            boolean isMergedCell = false;
            for(int col=this.boardSize-1; col>=0; col--) {
                if(Objects.nonNull(this.board.getGrid()[row][col])){
                    if(filledIndex != this.boardSize && !isMergedCell && this.board.getGrid()[row][col] == this.board.getGrid()[row][filledIndex]) {
                        this.board.getGrid()[row][filledIndex] *=2;
                        isMergedCell = true;
                    } else {
                        filledIndex--;
                        isMergedCell = false;
                        this.board.getGrid()[row][filledIndex] = this.board.getGrid()[row][col];
                    }
                }
            }
            while(filledIndex >0){
                this.board.getGrid()[row][--filledIndex] = null;
            }
        }
    }

    @Override
    public void moveToTop() {
        for(int col=0; col<this.boardSize; col++){
            int filledIndex = -1;
            boolean isMergedCell = false;
            for(int row=0; row<this.boardSize; row++) {
                if(Objects.nonNull(this.board.getGrid()[row][col])){
                    if(filledIndex != -1 && !isMergedCell && this.board.getGrid()[row][col] == this.board.getGrid()[filledIndex][col]) {
                        this.board.getGrid()[filledIndex][col] *=2;
                        isMergedCell = true;
                    } else {
                        filledIndex++;
                        isMergedCell = false;
                        this.board.getGrid()[filledIndex][col] = this.board.getGrid()[row][col];
                    }
                }
            }
            while(filledIndex < this.boardSize-1){
                this.board.getGrid()[++filledIndex][col] = null;
            }
        }
    }

    @Override
    public void moveToBottom() {
        for(int col=0; col<this.boardSize; col++){
            int filledIndex = this.boardSize;
            boolean isMergedCell = false;
            for(int row=this.boardSize-1; row>=0; row--) {
                if(Objects.nonNull(this.board.getGrid()[row][col])){
                    if(filledIndex != this.boardSize && !isMergedCell && this.board.getGrid()[row][col] == this.board.getGrid()[filledIndex][col]) {
                        this.board.getGrid()[filledIndex][col] *=2;
                        isMergedCell = true;
                    } else {
                        filledIndex--;
                        isMergedCell = false;
                        this.board.getGrid()[filledIndex][col] = this.board.getGrid()[row][col];
                    }
                }
            }
            while(filledIndex >0){
                this.board.getGrid()[--filledIndex][col] = null;
            }
        }
    }

    @Override
    public boolean isBoardFull() {
        this.emptyPositions = getEmptyPositions();
        return this.emptyPositions.size() == 0;
    }

    @Override
    public boolean hasGoalValue() {
        for(int row=0; row<this.boardSize; row++){
            for(int col=0; col<this.boardSize; col++) {
                if(Objects.nonNull(this.board.getGrid()[row][col]) && Constants.GOAL_VALUE == this.board.getGrid()[row][col]) {
                    return true;
                }
            }
        }
        return false;
    }
}
