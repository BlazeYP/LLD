package tictactoe.services;

public interface GameInitialiser {
    void initialise();
    BoardService getBoardService();
    PlayerService getPlayerService();
    WinningStrategy getWinningStrategy();
}
