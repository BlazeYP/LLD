package tictactoe.serviceImpl;

import tictactoe.Constants;
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
    public boolean addPiece(Position position, Piece piece) {
        if(positionIsValid(position) && !this.occupiedPositions.contains(position)){
            this.board.getGrid()[position.getX()][position.getY()] = piece;
            this.occupiedPositions.add(position);
            return true;
        }
        return false;
    }

    @Override
    public void printBoard() {
        int size = this.board.getSize();
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++){
                System.out.print(this.board.getGrid()[row][col] + Constants.separator);
            }
            System.out.println();
        }
    }

    @Override
    public void resetBoard() {
        int size = this.board.getSize();
        for(int row=0; row<size; row++){
            for(int col=0; col<size; col++) {
                this.board.getGrid()[row][col] = null;
            }
        }
        this.occupiedPositions = getOccupiedPositions(this.board);
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

    private boolean positionIsValid(Position p){
        int x = p.getX(), y = p.getY(), size = this.board.getSize();
        return x>=0 && x<size && y>=0 && y<size;
    }
}
