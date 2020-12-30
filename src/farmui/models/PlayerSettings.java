package farmui.models;

/**
 * Representation of a PlayerSettings object.
 */
public class PlayerSettings {
    private String difficulty;
    private String season;
    private String seedType;

    /**
     * Constructor that initializes the PlayerSettings.
     * @param difficulty String that represents the difficulty for the player.
     * @param season String that represents the season.
     * @param seedType String that represents the seedtype.
     */
    public PlayerSettings(String difficulty, String season, String seedType) {
        this.difficulty = difficulty;
        this.season = season;
        this.seedType = seedType;
    }

    /**
     * No args Constructor for PlayerSettings.
     */
    public PlayerSettings() {
        this.difficulty = "Easy";
        this.season = "Winter";
        this.seedType = "Apple";
    }

    /**
     * method that returns difficulty
     * @return difficulty string
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * method that returns season
     * @return season string
     */
    public String getSeason() {
        return season;
    }

    /**
     * method that returns seed
     * @return seed string
     */
    public String getSeedType() {
        return seedType;
    }

    /**
     * method that sets difficulty
     * @param difficulty difficulty for player
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * method that sets season
     * @param season season for player
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * method that sets seed
     * @param seedType seed for player
     */
    public void setSeedType(String seedType) {
        this.seedType = seedType;
    }
}
