package main.java.Board;

import java.util.HashMap;
import java.util.Random;

public class Snake {

    private HashMap<Integer,Integer> snakes;
    public Snake(HashMap<Integer,Integer> snakes)
    {
        this.snakes = snakes;


    }

    public boolean checkForSnake(int position) {
        if(snakes.containsKey(position))
            return true;
        return false;
    }

    public int getSnakeTailPosition(int position) {
        return snakes.get(position);
    }
}
