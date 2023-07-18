package tictactoe.serviceImpl;

import tictactoe.model.Piece;
import tictactoe.model.Player;
import tictactoe.model.Position;
import tictactoe.service.BoardService;
import tictactoe.service.GameService;

import java.util.*;

public class GameServiceImpl implements GameService {

    private List<Player> playerList;
    private BoardService boardService;
    private Deque<Player> playerDeque;
    private Piece winnerPiece;

    public GameServiceImpl(List<Player> playerList, BoardService boardService) {
        this.playerList = playerList;
        this.boardService = boardService;
    }

    @Override
    public void initialise() {
        this.boardService.initialise();
        this.playerDeque = new ArrayDeque<>();
        for(Player p : this.playerList){
            this.playerDeque.addLast(p);
        }
    }

    @Override
    public void start() {
        //Print the initial board
        System.out.println("Game started!");
        this.boardService.printBoard();
    }

    @Override
    public void restart() {
        //Reset board
        this.boardService.resetBoard();
        //Reset player Deque
        this.initialise();
        this.start();
    }

    @Override
    public void showTurn() {
        System.out.println(this.playerDeque.peek().getName() +"'s chance:");
    }

    @Override
    public void makeMove(Position position) throws Exception{
        Player playingPlayer = this.playerDeque.peek();
        this.boardService.addPiece(position,playingPlayer.getPlayingPiece());
        this.boardService.printBoard();
        playerDeque.removeFirst();
        playerDeque.addLast(playingPlayer);
    }

    @Override
    public boolean isOver() {
        int boardSize = this.boardService.getBoardSize();
        Map<Piece, Integer> freqMap = new HashMap<>();

        //Checking rows
        try {
            for (int row = 0; row < boardSize; row++) {
                for (int col = 0; col < boardSize; col++) {
                    Piece piece = this.boardService.getPiece(new Position(row, col));
                    if(freqMap.containsKey(piece)){
                        freqMap.put(piece, freqMap.get(piece) + 1);
                    } else {
                        freqMap.put(piece, 1);
                    }
                }
                if(searchWinner(freqMap)){
                    return true;
                }
                setMapFreqToZero(freqMap);
            }
        } catch (Exception e){

        }

        //Checking cols
        try {
            for (int col = 0; col < boardSize; col++) {
                for (int row = 0; row < boardSize; row++) {
                    Piece piece = this.boardService.getPiece(new Position(row, col));
                    if(freqMap.containsKey(piece)){
                        freqMap.put(piece, freqMap.get(piece) + 1);
                    } else {
                        freqMap.put(piece, 1);
                    }
                }
                if(searchWinner(freqMap)){
                    return true;
                }
                setMapFreqToZero(freqMap);
            }
        } catch (Exception e){

        }

        //Checking Left Diagonal
        try {
            for (int idx = 0; idx < boardSize; idx++) {
                Piece piece = this.boardService.getPiece(new Position(idx, idx));
                if(freqMap.containsKey(piece)){
                    freqMap.put(piece, freqMap.get(piece) + 1);
                } else {
                    freqMap.put(piece, 1);
                }

            }
        } catch (Exception e){

        }
        if(searchWinner(freqMap)){
            return true;
        }
        setMapFreqToZero(freqMap);

        //Checking Right Diagonal
        try {
            for (int idx = 0; idx < boardSize; idx++) {
                Piece piece = this.boardService.getPiece(new Position(idx, boardSize -idx -1));
                if(freqMap.containsKey(piece)){
                    freqMap.put(piece, freqMap.get(piece) + 1);
                } else {
                    freqMap.put(piece, 1);
                }

            }
        } catch (Exception e){

        }
        if(searchWinner(freqMap)){
            return true;
        }

        return false;
    }

    @Override
    public Player getWinner() {
        for(Player p : this.playerList){
            if(p.getPlayingPiece().equals(this.winnerPiece)){
                return p;
            }
        }
        return null;
    }

    private void setMapFreqToZero(Map<Piece, Integer> freqMap){
        for(Map.Entry<Piece, Integer> entry : freqMap.entrySet()){
            entry.setValue(0);
        }
    }

    private boolean searchWinner(Map<Piece, Integer> freqMap){
        int boardSize = this.boardService.getBoardSize();
        for(Map.Entry<Piece, Integer> entry : freqMap.entrySet()){
            if(entry.getKey() != null && entry.getValue().equals(boardSize)){
                this.winnerPiece = entry.getKey();
                return true;
            }
        }
        return false;
    }
}
