package tictactoe.serviceImpl;

import tictactoe.Constants;
import tictactoe.exceptions.InvalidPositionException;
import tictactoe.exceptions.UnableToAddException;
import tictactoe.model.Board;
import tictactoe.model.Piece;
import tictactoe.model.Position;
import tictactoe.service.BoardService;

import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService {

    private Board board;
    private List<Position> occupiedPositions;

    public BoardServiceImpl(Board board) {
        this.board = board;
    }

    @Override
    public void initialise() {
        this.occupiedPositions = this.getOccupiedPositions(board);
    }

    @Override
    public void addPiece(Position position, Piece piece) throws Exception{
        if(isPositionValid(position)){
            if(!this.occupiedPositions.contains(position)) {
                this.board.getGrid()[position.getX()][position.getY()] = piece;
                this.occupiedPositions.add(position);
            } else {
                throw new UnableToAddException("ERROR | Already occupied position!");
            }
        } else {
            throw new InvalidPositionException("ERROR | Invalid Position to add on!");
        }
    }

    @Override
    public void printBoard() {
        int size = this.board.getSize();
        System.out.println();
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++){
                if(null != this.board.getGrid()[row][col]) {
                    System.out.print(this.board.getGrid()[row][col]);
                }
                System.out.print(Constants.separator);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void resetBoard() {
        int size = this.board.getSize();
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++) {
                this.board.getGrid()[row][col] = null;
            }
        }
    }

    @Override
    public int getBoardSize() {
        return this.board.getSize();
    }

    @Override
    public Piece getPiece(Position p) throws Exception{
        if(isPositionValid(p)){
            return this.board.getGrid()[p.getX()][p.getY()];
        } else {
            throw new InvalidPositionException("ERROR | Invalid position !");
        }
    }

    @Override
    public boolean isBoardFull() {
        return this.occupiedPositions.size() == this.board.getSize() * this.board.getSize();
    }

    private List<Position> getOccupiedPositions(Board board){
        List<Position> occupiedPositions = new ArrayList<>();
        for(int rowNo=0; rowNo< board.getSize(); rowNo++){
            for(int colNo=0; colNo < board.getSize(); colNo++ ){
                if(null != board.getGrid()[rowNo][colNo]){
                    Position p = new Position(rowNo, colNo);
                    occupiedPositions.add(p);
                }
            }
        }
        return occupiedPositions;
    }

    private boolean isPositionValid(Position p){
        int x = p.getX(), y = p.getY(), size = this.board.getSize();
        return x>=0 && x<size && y>=0 && y<size;
    }
}
