package game2048.services;

public interface BoardService {
    void initialise();
    void printBoard();
    void reset();
    void moveToLeft();
    void moveToRight();
    void moveToTop();
    void moveToBottom();
    boolean isBoardFull();

}
