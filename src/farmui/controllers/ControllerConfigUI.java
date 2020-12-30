package farmui.controllers;

import farmui.alerts.AlertBoxName;
import farmui.alerts.AlertBoxContinue;
import farmui.alerts.AlertBoxDifficulty;
import farmui.alerts.AlertBoxSeason;
import farmui.alerts.AlertBoxSeed;
import farmui.models.Music;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import farmui.models.Player;
import farmui.models.Plant;

import java.io.IOException;

/**
 * Controller for JavaFX actions.
 */
public class ControllerConfigUI {

    private Player player;

    /**
     * Method that checks to make sure the config screen is open.
     */
    @FXML
    protected void initialize() {
        System.out.println("Config Screen Open");
    }
    /**
     * Method that transitions between the ConfigUI and FarmUI.
     * @param event the ActionEvent being handled.
     * @throws IOException Exception that is handled if transitioning to fXML file.
     */
    public void changeScreenButtonToUI(ActionEvent event) throws Exception {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../displays/FarmUI.fxml"));
        Parent myParent2 = loader2.load();
        Controller farmUI = (Controller) loader2.getController();
        farmUI.setPlayer(this.player);
        loader2.setController(farmUI);
        Scene myScene2 = new Scene(myParent2);
        Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window2.setMinWidth(800);
        window2.setScene(myScene2);
        farmUI.setUpWindow();
        window2.show();
    }
    /**
     * Method that prints the text once the enter key is pressed.
     * @param event the ActionEvent being handled.
     */
    public void typeText(ActionEvent event) { // TEST FOR TEXTBOX
        System.out.println(nameTextField.getText());
    }

    /**
     * Method that submits the name that is inputted.
     * @param event the ActionEvent being handled.
     */
    public void submitName(ActionEvent event) {

        String name = nameTextField.getText(); // NAME RECORDED HERE FOR NEXT PART
        player.setName(name);
        System.out.println(nameTextField.getText());
        if (name == null || name.equals("")) {
            AlertBoxName.display();
        }
    }

    /**
     * Method that selects an easy difficulty.
     * @param event the ActionEvent being handled.
     */
    public void selectMenuEasy(ActionEvent event) {
        menuButtonD.setText("Easy");
        player.getSettings().setDifficulty("Easy");
    }

    /**
     * Method that selects an medium difficulty.
     * @param event the ActionEvent being handled.
     */
    public void selectMenuMedium(ActionEvent event) {
        menuButtonD.setText("Medium");
        player.getSettings().setDifficulty("Medium");
    }

    /**
     * Method that selects an hard difficulty.
     * @param event the ActionEvent being handled.
     */
    public void selectMenuHard(ActionEvent event) {
        menuButtonD.setText("Hard");
        player.getSettings().setDifficulty("Hard");
    }

    /**
     * Method that submits the difficulty.
     * @param event the ActionEvent being handled.
     */
    public void submitDifficulty(ActionEvent event) {
        String difficulty = menuButtonD.getText(); // NAME RECORDED HERE FOR NEXT PART
        player.getSettings().setDifficulty(difficulty);
        if (difficulty.equals("Difficulty")) {
            AlertBoxDifficulty.display();
        }
        System.out.println(player.getSettings().getDifficulty());
    }

    /**
     * Method that selects a sunflower.
     * @param event the ActionEvent being handled.
     */
    public void selectSunflower(ActionEvent event) {
        menuButtonS.setText("Sunflower");
        player.getSettings().setSeedType("Sunflower");
    }

    /**
     * Method that selects a apple.
     * @param event the ActionEvent being handled.
     */
    public void selectApple(ActionEvent event) {
        menuButtonS.setText("Apple");
        player.getSettings().setSeedType("Apple");
    }

    /**
     * Method that selects a tomato.
     * @param event the ActionEvent being handled.
     */
    public void selectTomato(ActionEvent event) {
        menuButtonS.setText("Tomato");
        player.getSettings().setSeedType("Tomato");
    }

    public Plant[] buildPlantArray() {
        Plant[] temp = new Plant[15];
        for (int i = 0; i < player.getMaxPlants(); i++) {
            temp[i] = new Plant(this.player.getSettings().getSeedType(), false);
        }
        return temp;
    }

    /**
     * Method that submits a seed.
     * @param event the ActionEvent being handled.
     */
    public void submitSeed(ActionEvent event) {
        String seed = menuButtonS.getText();
        if (seed.equals("Choose a Seed")) {
            AlertBoxSeed.display();
        }
        player.getSettings().setSeedType(seed);
        player.setPlantArray(this.buildPlantArray());
        System.out.println(player.getSettings().getSeedType());
    }

    /**
     * Method that selects the season fall.
     * @param event the ActionEvent being handled.
     */
    public void selectFall(ActionEvent event) {
        menuButtonSea.setText("Fall");
        player.getSettings().setSeason("Fall");
    }

    /**
     * Method that selects the season summer.
     * @param event the ActionEvent being handled.
     */
    public void selectSummer(ActionEvent event) {
        menuButtonSea.setText("Summer");
        player.getSettings().setSeason("Summer");
    }

    /**
     * Method that selects the season spring.
     * @param event the ActionEvent being handled.
     */
    public void selectSpring(ActionEvent event) {
        menuButtonSea.setText("Spring");
        player.getSettings().setSeason("Spring");
    }

    /**
     * Method that selects the season winter.
     * @param event the ActionEvent being handled.
     */
    public void selectWinter(ActionEvent event) {
        menuButtonSea.setText("Winter");
        player.getSettings().setSeason("Winter");
    }

    /**
     * Method that submits the season.
     * @param event the ActionEvent being handled.
     */
    public void submitSeason(ActionEvent event) {
        String season = menuButtonSea.getText();
        player.getSettings().setSeason(season);
        if (season.equals("Choose a Season")) {
            AlertBoxSeason.display();
        }
        System.out.println(player.getSettings().getSeason());
        //keep data for season in here for handling.
    }

    /**
     * Method that creates the transition from the ConfigUI to FarmUI.
     * @param event the ActionEvent being handled.
     */
    public void continueScreen(ActionEvent event) {
        if (player.getName().equals("") || player.getName().equals("")
                || player.getSettings().getSeedType().equals("")
                || player.getSettings().getSeason().equals("")) {
            AlertBoxContinue.display();
        }
        System.out.println("Transition needs to happen here");
    }

    /**
     * Method that returns the difficulty for the player.
     * @return the player difficulty.
     */
    public String getDifficulty() {
        return player.getSettings().getDifficulty();
    }

    /**
     * Method that returns the seed type for the player.
     * @return the seed type.
     */
    public String getSeed() {
        return player.getSettings().getSeedType();
    }

    /**
     * Method that returns the season for the player.
     * @return the season.
     */
    public String getSeason() {
        return player.getSettings().getSeason();
    }
    @FXML
    private TextField nameTextField;
    @FXML
    private MenuButton menuButtonD;
    @FXML
    private MenuButton menuButtonS;
    @FXML
    private MenuButton menuButtonSea;

    /**
     * get player passed from welcome ui
     * @return player with basic settings
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * set new player for game
     * @param player player of farm game
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
