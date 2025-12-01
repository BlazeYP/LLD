package tictactoe.serviceImpl;

import tictactoe.models.Piece;
import tictactoe.models.Position;
import tictactoe.services.BoardService;
import tictactoe.services.WinningStrategy;

import java.util.Objects;

public class AllCheckWinningStrategyImpl implements WinningStrategy {
    private final BoardService boardService;
    private Piece winningPiece;

    public AllCheckWinningStrategyImpl(BoardService boardService) {
        this.boardService = boardService;
    }

    private Piece getPiece(int x, int y) {
        Position pos = new Position(x, y);
        try {
            return boardService.getPiece(pos);
        } catch (Exception e) {
            System.out.println("Something went wrong!!");
        }
        return null;
    }

    private boolean checkForRows() {
        int size = boardService.getBoardSize(), row, col;
        for(row=0; row<size; row++) {
            Piece p1 = getPiece(row,0);
            if(Objects.nonNull(p1)) {
                for(col=1; col<size; col++) {
                    if(!p1.equals(getPiece(row,col))) break;
                }
                if(col == size) {
                    winningPiece = p1;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForColumns() {
        int size = boardService.getBoardSize(), row, col;
        for(col=0; col<size; col++) {
            Piece p1 = getPiece(0, col);
            if(Objects.nonNull(p1)) {
                for(row=1; row<size; row++) {
                    if(!p1.equals(getPiece(row,col))) break;
                }
                if(row == size) {
                    winningPiece = p1;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForDiagonals() {
        int size = boardService.getBoardSize();
        Piece p1 = getPiece(0, 0);
        if(Objects.nonNull(p1)) {
            for (int d = 1; d < size; d++) {
                if (!p1.equals(getPiece(d, d))) return false;
            }
            winningPiece = p1;
            return true;
        }
        return false;
    }

    private boolean checkForAntiDiagonals() {
        int size = boardService.getBoardSize();
        Piece p1 = getPiece(0, size-1);
        if(Objects.nonNull(p1)) {
            for (int d = 1; d < size; d++) {
                if (!p1.equals(getPiece(d, size - 1 - d))) return false;
            }
            winningPiece = p1;
            return true;
        }
        return false;
    }


    @Override
    public Piece hasWon() {
        if(checkForRows() || checkForColumns() || checkForDiagonals() || checkForAntiDiagonals()) {
            return winningPiece;
        }
        return null;
    }
}
