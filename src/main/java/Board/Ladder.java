package main.java.Board;

import java.util.HashMap;
import java.util.Random;

public class Ladder {

    private HashMap<Integer,Integer> ladders;

    public Ladder(HashMap<Integer,Integer> ladders)
    {
        this.ladders = ladders;

    }


    public boolean checkForLadder(int position) {
        if(ladders.containsKey(position))
            return true;
        return false;
    }

    public int getLadderHeadPosition(int position) {
        return ladders.get(position);
    }
}
