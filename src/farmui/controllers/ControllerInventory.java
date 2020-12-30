package farmui.controllers;

import farmui.models.PlantStatus;
import farmui.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import farmui.models.Plant;
import java.util.ArrayList;

import java.io.IOException;

public class ControllerInventory {

    private Player player;
    @FXML
    private Label seed1;
    @FXML
    private Label seed2;
    @FXML
    private Label seed3;
    @FXML
    private Label seed4;
    @FXML
    private Label seed5;
    @FXML
    private Label seed6;
    @FXML
    private Label seed7;
    @FXML
    private Label seed8;
    @FXML
    private Label seed9;
    @FXML
    private Label seed10;
    @FXML
    private Label crop1;
    @FXML
    private Label crop2;
    @FXML
    private Label crop3;
    @FXML
    private Label crop4;
    @FXML
    private Label crop5;
    @FXML
    private Label crop6;
    @FXML
    private Label crop7;
    @FXML
    private Label crop8;
    @FXML
    private Label crop9;
    @FXML
    private Label crop10;
    @FXML
    private Label pest1;
    @FXML
    private Label pest2;
    @FXML
    private Label pest3;
    @FXML
    private Label pest4;
    @FXML
    private Label pest5;
    @FXML
    private Label pest6;
    @FXML
    private Label pest7;
    @FXML
    private Label pest8;
    @FXML
    private Label pest9;
    @FXML
    private Label pest10;
    @FXML
    private Label fert1;
    @FXML
    private Label fert2;
    @FXML
    private Label fert3;
    @FXML
    private Label fert4;
    @FXML
    private Label fert5;
    @FXML
    private Label fert6;
    @FXML
    private Label fert7;
    @FXML
    private Label fert8;
    @FXML
    private Label fert9;
    @FXML
    private Label fert10;

    /**
     * Method that checks to make sure the market screen is open.
     */
    @FXML
    protected void initialize() {
        System.out.println("Welcome Screen Open");
    }

    public void setUpWindow() {
        Label[] cropArr = {crop1, crop2, crop3, crop4, crop5, crop6, crop7, crop8, crop9, crop10};
        Label[] seedArr = {seed1, seed2, seed3, seed4, seed5, seed6, seed7, seed8, seed9, seed10};
        Label[] pestArr = {pest1, pest2, pest3, pest4, pest5, pest6, pest7, pest8, pest9, pest10};
        Label[] fertArr = {fert1, fert2, fert3, fert4, fert5, fert6, fert7, fert8, fert9, fert10};
        ArrayList<Plant> crops = new ArrayList<>(10);
        ArrayList<Plant> seeds = new ArrayList<>(10);
        int emptyPest = 0;
        int emptySeed = 0;
        int emptyCrop = 0;
        int emptyFert = 0;
        for (int i = 0; i < player.getStock().size(); i++) {
            pestArr[emptyPest++].setText(player.getStock().get(i).getName());
        }
        for (int j = 0; j < player.getFertilizers().size(); j++) {
            fertArr[emptyFert++].setText(player.getFertilizers().get(j).getName());
        }
        for (Plant plant : player.getInventory()) {
            if (plant.getStatus() == PlantStatus.SEED) {
                seedArr[emptySeed].setText(plant.getName());
                emptySeed++;
            } else {
                cropArr[emptyCrop].setText(plant.getName());
                emptyCrop++;
            }
        }
    }

    /**
     * Method that handles event for when return button is pushed.
     * @param event the ActionEvent being handled.
     * @throws IOException FileNotFoundException
     */
    public void changeReturnButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../displays/FarmUI.fxml"));
        Parent myParent2 = loader2.load();
        Controller farmUI = (Controller) loader2.getController();
        farmUI.setPlayer(this.player);
        loader2.setController(farmUI);
        Scene myScene2 = new Scene(myParent2);
        Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window2.setScene(myScene2);
        farmUI.setUpWindow1();
        window2.show();
    }

    /**
     * Method that transitions screen from FarmUI to Market.
     * @param event the Actionevent being handled
     * @throws IOException FileNotFoundException
     */
    public void pressMarket(ActionEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../displays/MarketUI.fxml"));
        Parent myParent2 = loader2.load();
        ControllerMarketUI marketUI = (ControllerMarketUI) loader2.getController();
        marketUI.setPlayer(this.player);
        loader2.setController(marketUI);
        Scene myScene2 = new Scene(myParent2);
        Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window2.setScene(myScene2);
        marketUI.setUpWindow();
        window2.show();
    }

    /**
     * get player passed from config ui
     * @return player with settings from config
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
