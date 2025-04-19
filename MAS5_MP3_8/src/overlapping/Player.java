package overlapping;

import java.util.EnumSet;

public class Player {
    private final String name;
    private Integer STR;
    private Integer INT;
    private Integer DEX;
    private Integer CHR;
    private final EnumSet<PlayerClass> playerClasses;

    public Player(String name, EnumSet<PlayerClass> playerClasses) {
        if (playerClasses == null || playerClasses.isEmpty()) {
            throw new NullPointerException("playerClasses is null or empty");
        }
        this.playerClasses = playerClasses;
        this.name = name;
    }

    public Integer getSTR() {
        if (!playerClasses.contains(PlayerClass.Barbarian)) {
            throw new UnsupportedOperationException("Player is not a Barbarian");
        }
        return STR;
    }

    public void setSTR(Integer STR) {
        if (!playerClasses.contains(PlayerClass.Barbarian)) {
            throw new UnsupportedOperationException("Player is not a Barbarian");
        }
        this.STR = STR;
    }
}
