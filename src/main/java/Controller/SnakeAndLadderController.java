package main.java.Controller;

import main.java.Board.Board;
import main.java.Players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderController {

    List<Player> playerList;
    Board board;

    Scanner sc = new Scanner(System.in);
    public SnakeAndLadderController(List<Player> playerList,Board board)
    {
        this.playerList = playerList;
        this.board = board;
    }

    private static void handleSnakeAndLadder(Board board, Player currentPlayer)
    {
        int position = currentPlayer.getPlayerPosition();

        if(board.hasSnake(position))
        {
            System.out.println("Snake bites you");
            int snakeTail = board.getSnakeTail(position);
            currentPlayer.setPlayerPosition(snakeTail);
        }
        else if(board.hasLadder(position))
        {
            System.out.println("Ladder present");
            int ladderHead = board.getLadderHead(position);
            currentPlayer.setPlayerPosition(ladderHead);
        }
    }

    private static int switchPlayer(int currentPlayerIndex)
    {
        if (currentPlayerIndex == 0) {
            return 1;
        }
        else
            return 0;
    }

    private static int rollDice()
    {
        return (int) (Math.random() * 6) + 1;
    }

    public void startGame()
    {
        boolean gameFinished = false;
        int currentPlayerIndex  = 0;
        while(!gameFinished)
        {
            Player currentPlayer = playerList.get(currentPlayerIndex);
            System.out.println(currentPlayer.getPlayerName()+" ,Please any key roll the dice");
            sc.nextLine();
            int diceRoll = rollDice();
            int newPlayerPosition = currentPlayer.getPlayerPosition() + diceRoll;
            if(newPlayerPosition<= board.getSize()*board.getSize())
            {
                currentPlayer.setPlayerPosition(newPlayerPosition);
                if(newPlayerPosition == board.getSize()*board.getSize())
                {
                    System.out.println(currentPlayer.getPlayerName() + " wins!!!!");
                    break;
                }
                else
                {
                    handleSnakeAndLadder(board,currentPlayer);
                }
            }
            currentPlayerIndex = switchPlayer(currentPlayerIndex);
        }
    }

}
