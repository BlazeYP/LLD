package tictactoe.models;

public class Board {
    private int size;
    private Piece[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public void setGrid(Piece[][] grid) {
        this.grid = grid;
    }
}
