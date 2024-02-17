package main.java.Board;

import java.util.HashMap;
import java.util.Random;

public class BoardImpl implements Board {
    private int boardSize;
    private Snake snake;
    private Ladder ladder;
    public BoardImpl(int size)
    {
        boardSize = size;
        HashMap<Integer,Integer> obstacle = setRandomSnakesAndLadders(size);
        snake = new Snake(obstacle);
        obstacle.clear();
        obstacle = setRandomSnakesAndLadders(size);
        ladder = new Ladder(obstacle);
    }

    public HashMap<Integer,Integer> setRandomSnakesAndLadders(int size)
    {
        HashMap<Integer,Integer> obstacles = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int startCell = random.nextInt(size - 2) + 2;
            int endCell = random.nextInt(startCell - 1) + 1;
            if(!obstacles.containsKey(startCell))
                obstacles.put(startCell, endCell);
        }
        return obstacles;
    }

    @Override
    public int getSize() {
        return this.boardSize;
    }

    @Override
    public boolean hasSnake(int position) {
        if(snake.checkForSnake(position))
            return true;
        return false;
    }

    @Override
    public boolean hasLadder(int position) {
        if(ladder.checkForLadder(position))
            return true;
        return false;
    }

    @Override
    public int getSnakeTail(int position) {
        return snake.getSnakeTailPosition(position);
    }

    @Override
    public int getLadderHead(int position) {
        return ladder.getLadderHeadPosition(position);
    }
}
