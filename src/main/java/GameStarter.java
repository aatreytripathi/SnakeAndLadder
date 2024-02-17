package main.java;

import main.java.Board.Board;
import main.java.Board.BoardImpl;
import main.java.Controller.SnakeAndLadderController;
import main.java.Players.Player;
import main.java.Players.PlayerAvatar;
import main.java.Players.PlayerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();
        Board board = new BoardImpl(10);
        System.out.println("Welcome to Saap and Seedhi Game");
        System.out.println("Press Any Key To start the Game");
        String startGame = sc.nextLine();

        System.out.println("Enter First Player Name");
        String playerOneName = sc.next();

        System.out.println("Choose First Player Avatar");
        System.out.println("1.Blue \n 2.Red \n 3.Green \n 4.Yellow");
        int playerOneAvatarInput = sc.nextInt();
        PlayerAvatar playerOneAvatar = null;
        switch (playerOneAvatarInput)
        {
            case 1:
                playerOneAvatar = PlayerAvatar.Blue;
                break;
            case 2:
                playerOneAvatar = PlayerAvatar.Red;
                break;
            case 3:
                playerOneAvatar = PlayerAvatar.Green;
                break;
            case 4:
                playerOneAvatar = PlayerAvatar.Yellow;
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }

        Player player = new PlayerImpl(playerOneName,playerOneAvatar);
        playerList.add(player);
        System.out.println("Enter Second Player Name");
        String playerTwo = sc.next();
        System.out.println("Choose Second Player Avatar");
        System.out.println("1.Blue \n 2.Red \n 3.Green \n 4.Yellow");
        int playerTwoAvatarInput = sc.nextInt();
        if(playerTwoAvatarInput!=playerOneAvatarInput) {
            PlayerAvatar playerTwoAvatar = null;
            switch (playerOneAvatarInput) {
                case 1:
                    playerTwoAvatar = PlayerAvatar.Blue;
                    break;
                case 2:
                    playerTwoAvatar = PlayerAvatar.Red;
                    break;
                case 3:
                    playerTwoAvatar = PlayerAvatar.Green;
                    break;
                case 4:
                    playerTwoAvatar = PlayerAvatar.Yellow;
                    break;
                default:
                    System.out.println("Incorrect Input");
                    break;
            }
            player = new PlayerImpl(playerTwo,playerTwoAvatar);
            playerList.add(player);
            SnakeAndLadderController snakeAndLadderController = new SnakeAndLadderController(playerList,board);
            snakeAndLadderController.startGame();
        }
        else {
            System.out.println("Avatar Already Selected");
        }

    }
}
