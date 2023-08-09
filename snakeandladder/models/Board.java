package snakeandladder.models;

import java.util.List;

public class Board {
    int size;
    List<Snake> snakesList;
    List<Ladder> ladderList;

    public Board() {
    }

    public Board(int size) {
        this.size = size;
    }

    public Board(int size, List<Snake> snakesList, List<Ladder> ladderList) {
        this.size = size;
        this.snakesList = snakesList;
        this.ladderList = ladderList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakesList() {
        return snakesList;
    }

    public void setSnakesList(List<Snake> snakesList) {
        this.snakesList = snakesList;
    }

    public List<Ladder> getLadderList() {
        return ladderList;
    }

    public void setLadderList(List<Ladder> ladderList) {
        this.ladderList = ladderList;
    }
}
