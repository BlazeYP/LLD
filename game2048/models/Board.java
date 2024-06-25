package game2048.models;

public class Board {
    private int size;
    private Integer[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Integer[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer[][] getGrid() {
        return grid;
    }

    public void setGrid(Integer[][] grid) {
        this.grid = grid;
    }
}
