package game2048.serviceImpl;

import game2048.exceptions.InvalidMoveException;
import game2048.services.BoardService;
import game2048.services.GameService;

import java.util.Scanner;

public class GameServiceImpl implements GameService {
    private BoardService boardService;

    public GameServiceImpl(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public void initialise() {
        this.boardService.initialise();
    }

    @Override
    public void start() {
        System.out.println("Rules:");
        System.out.println("1) Move Left, Press L");
        System.out.println("2) Move Right, Press R");
        System.out.println("3) Move Up, Press U");
        System.out.println("4) Move Down, Press D");
        System.out.println("To Restart, Press X");
        System.out.println("Game Started!!");

        this.boardService.printBoard();
    }

    @Override
    public void makeMove() throws InvalidMoveException {
        System.out.print("Enter your move: ");
        Scanner sc = new Scanner(System.in);
        char option = sc.next().charAt(0);
        sc.nextLine();

        switch (option){
            case 'L':
                this.boardService.moveToLeft();
                break;
            case 'R':
                this.boardService.moveToRight();
                break;
            case 'U':
                this.boardService.moveToTop();
                break;
            case 'D':
                this.boardService.moveToBottom();
                break;
            case 'X':
                this.restart();
                return;
            default:
                throw new InvalidMoveException("Invalid Move, Try Again");
        }
        this.boardService.insertTile();
        this.boardService.printBoard();
    }

    @Override
    public void restart() {
        System.out.println("Restarting the game!!----------");
        this.boardService.reset();
        this.boardService.initialise();
        this.boardService.printBoard();
    }

    @Override
    public boolean isGameOver() {
        return this.boardService.isBoardFull() || this.boardService.hasGoalValue();
    }

    @Override
    public boolean isWinner() {
        return this.boardService.hasGoalValue();
    }
}
