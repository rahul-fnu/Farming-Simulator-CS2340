package farmui.controllers;
import farmui.models.Music;
import farmui.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for JavaFX actions
 */
public class ControllerEndScreen {

    private Player player;

    /**
     * Method that makes sure the welcome screen is properly initialized.
     */
    @FXML
    protected void initialize() {
        System.out.println("End Screen Open");
    }
    /**
     * Method that transitions between start and configui.
     * @param event the ActionEvent being handled.
     * @throws IOException Exception that occurs when screen doesn't change properly.
     */
    public void changeScreenButtonPushed(ActionEvent event) throws Exception {
        Player p = new Player();
        this.player = p;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../displays/ConfigUI.fxml"));
        Parent myParent = loader.load();
        ControllerConfigUI configUI = (ControllerConfigUI) loader.getController();
        configUI.setPlayer(this.player);
        Scene myScene = new Scene(myParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(myScene);
        window.show();
    }

    /**
     * get player for new farm game
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