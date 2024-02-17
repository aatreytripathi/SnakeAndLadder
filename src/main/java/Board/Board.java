package main.java.Board;

public interface Board {

    int getSize();

    boolean hasSnake(int position);

    boolean hasLadder(int position);

    int getSnakeTail(int position);

    int getLadderHead(int position);
}
