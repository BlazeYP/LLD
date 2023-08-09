package snakeandladder.service;

public interface BoardService {
    void initialise();
    int getSize();
    int getFinalPosition(int position);
}
