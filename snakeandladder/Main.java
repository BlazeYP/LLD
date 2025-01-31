package snakeandladder;

import snakeandladder.models.Board;
import snakeandladder.models.Player;
import snakeandladder.service.BoardService;
import snakeandladder.service.Dice;
import snakeandladder.service.GameService;
import snakeandladder.serviceImpl.BoardServiceImplManual;
import snakeandladder.serviceImpl.DiceImpl;
import snakeandladder.serviceImpl.GameServiceImpl;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static Deque<Player> getPlayers() {
        System.out.println("Enter the number of players: ");
        int playerCount = sc.nextInt();
        sc.nextLine();
        Deque<Player> playerList = new ArrayDeque<>();
        for(int count=0; count<playerCount; count++){
            System.out.printf("Enter %s player name: ", count);
            String name = sc.nextLine();
            Player player = new Player(name);
            playerList.add(player);
        }

        return playerList;
    }

    private static List<Dice> getDices(){
        System.out.println("Enter number of dices: ");
        int diceCount = sc.nextInt();
        sc.nextLine();
        List<Dice> diceList = new ArrayList<>();
        for(int count=0; count<diceCount; count++){
            Dice dice = new DiceImpl();
            diceList.add(dice);
        }

        return diceList;
    }

    public static void main(String[] args) {
        //Creating components
        Board board = new Board();
        Deque<Player> playerList = getPlayers();
        List<Dice> diceList = getDices();


        //Initialising services
        BoardService boardService = new BoardServiceImplManual(board);
        GameService gameService = new GameServiceImpl(playerList, boardService, diceList);

        gameService.initialise();
        gameService.start();
        List<Player> winnerList = gameService.getWinners();

        int winnerIndex = 1;
        for(Player player : winnerList){
            System.out.printf("\n%s is the %s winner !!!!!\n", player.getName(), winnerIndex);
            winnerIndex++;
        }
    }

}
/*
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100


62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
 */