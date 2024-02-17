package main.java.Players;

public class PlayerImpl implements Player {

    private String playerName;
    private PlayerAvatar playerAvatar;

    private int playerPosition;
    public PlayerImpl(String name, PlayerAvatar playerAvatar)
    {
        this.playerName = name;
        this.playerAvatar = playerAvatar;
        this.playerPosition = 0;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public int getPlayerPosition() {
        return this.playerPosition;
    }

    @Override
    public void setPlayerPosition(int newPosition) {
        this.playerPosition = newPosition;
    }

}
