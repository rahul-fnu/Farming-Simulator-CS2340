package farmui.controllers;

import farmui.alerts.AlertBoxMachinery;
import farmui.alerts.AlertBoxWater;
import farmui.models.Music;
import farmui.models.PlantStatus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import farmui.models.Player;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import farmui.models.Plant;
import farmui.models.Fertilizer;

import javax.swing.*;
import java.io.IOException;
import java.util.Random;

/**
 * Controller for JavaFX actions
 */
public class Controller {

    private Player player;

    @FXML
    private Label plotCost = new Label();
    @FXML
    private Label difficultyLabel = new Label();
    @FXML
    private Label nameLabel = new Label();
    @FXML
    private Label seasonLabel = new Label();
    @FXML
    private Label seedLabel = new Label();
    @FXML
    private Label moneyLabel = new Label();
    @FXML
    private Label dateLabel = new Label();
    @FXML
    private Label harvestedLabel = new Label();
    @FXML
    private Button plot1 = new Button();
    @FXML
    private Button plot2 = new Button();
    @FXML
    private Button plot3 = new Button();
    @FXML
    private Button plot4 = new Button();
    @FXML
    private Button plot5 = new Button();
    @FXML
    private Button plot6 = new Button();
    @FXML
    private Button plot7 = new Button();
    @FXML
    private Button plot8 = new Button();
    @FXML
    private Button plot9 = new Button();
    @FXML
    private Button plot10 = new Button();
    @FXML
    private Button plot11 = new Button();
    @FXML
    private Button plot12 = new Button();
    @FXML
    private Button plot13 = new Button();
    @FXML
    private Button plot14 = new Button();
    @FXML
    private Button plot15 = new Button();
    @FXML
    private Button pest1 = new Button();
    @FXML
    private Button pest2 = new Button();
    @FXML
    private Button pest3 = new Button();
    @FXML
    private Button pest4 = new Button();
    @FXML
    private Button pest5 = new Button();
    @FXML
    private Button pest6 = new Button();
    @FXML
    private Button pest7 = new Button();
    @FXML
    private Button pest8 = new Button();
    @FXML
    private Button pest9 = new Button();
    @FXML
    private Button pest10 = new Button();
    @FXML
    private Button pest11 = new Button();
    @FXML
    private Button pest12 = new Button();
    @FXML
    private Button pest13 = new Button();
    @FXML
    private Button pest14 = new Button();
    @FXML
    private Button pest15 = new Button();
    @FXML
    private Button fert1 = new Button();
    @FXML
    private Button fert2 = new Button();
    @FXML
    private Button fert3 = new Button();
    @FXML
    private Button fert4 = new Button();
    @FXML
    private Button fert5 = new Button();
    @FXML
    private Button fert6 = new Button();
    @FXML
    private Button fert7 = new Button();
    @FXML
    private Button fert8 = new Button();
    @FXML
    private Button fert9 = new Button();
    @FXML
    private Button fert10 = new Button();
    @FXML
    private Button fert11 = new Button();
    @FXML
    private Button fert12 = new Button();
    @FXML
    private Button fert13 = new Button();
    @FXML
    private Button fert14 = new Button();
    @FXML
    private Button fert15 = new Button();
    @FXML
    private Label water1 = new Label();
    @FXML
    private Label water2 = new Label();
    @FXML
    private Label water3 = new Label();
    @FXML
    private Label water4 = new Label();
    @FXML
    private Label water5 = new Label();
    @FXML
    private Label water6 = new Label();
    @FXML
    private Label water7 = new Label();
    @FXML
    private Label water8 = new Label();
    @FXML
    private Label water9 = new Label();
    @FXML
    private Label water10 = new Label();
    @FXML
    private Label water11 = new Label();
    @FXML
    private Label water12 = new Label();
    @FXML
    private Label water13 = new Label();
    @FXML
    private Label water14 = new Label();
    @FXML
    private Label water15 = new Label();
    @FXML
    private Rectangle rect1 = new Rectangle();
    @FXML
    private Rectangle rect2 = new Rectangle();
    @FXML
    private Rectangle rect3 = new Rectangle();
    @FXML
    private Rectangle rect4 = new Rectangle();
    @FXML
    private Rectangle rect5 = new Rectangle();


    private int num1;
    private int num2;
    /**
     * Initializes the FarmUI.
     */
    @FXML
    protected void initialize() {

    }

    /**
     * Method that sets up plot and water arrays on screen.
     */
    public void createPlotWater() {
        Button[] plotArray = {plot1, plot2, plot3, plot4, plot5,
            plot6, plot7, plot8, plot9, plot10, plot11, plot12, plot13, plot14, plot15};
        Label[] waterArray = {water1, water2, water3, water4, water5,
            water6, water7, water8, water9, water10, water11, water12, water13, water14, water15};
        int counter = 0;
        for (int i = 0; i < plotArray.length; i++) {
            Button plot = plotArray[i];
            Label water = waterArray[i];
            if (player.getPlantArray()[counter] != null) {
                plot.setText(player.getPlantArray()[counter].toString());
                water.setText(Integer.toString(player.getPlantArray()[counter].getWaterLevel()));
            } else {
                plot.setText("EMPTY");
                water.setText("0");
            }

            counter++;
        }
    }

    /**
     * Method that sets up the window for the FarmUI.
     */
    @FXML
    public void setUpWindow() {
        System.out.println(this.player.getName());
        difficultyLabel.setText(player.getSettings().getDifficulty());
        nameLabel.setText(player.getName());
        seasonLabel.setText(player.getSettings().getSeason());
        seedLabel.setText(player.getSettings().getSeedType());
        if (player.getSettings().getDifficulty().equals("Easy")) {
            player.setMoney(500);
        } else if (player.getSettings().getDifficulty().equals("Medium")) {
            player.setMoney(300);
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            player.setMoney(100);
        }

        createPlotWater();

        moneyLabel.setText("$" + player.getMoney());
        dateLabel.setText("Day " + this.player.getDay());
        harvestedLabel.setText("0");
        plotCost.setText("$" + getPlotCost());
    }

    /**
     * Method that sets up the window for the FarmUI.
     */
    @FXML
    public void setUpWindow1() {
        System.out.println(this.player.getName());
        difficultyLabel.setText(player.getSettings().getDifficulty());
        nameLabel.setText(player.getName());
        seasonLabel.setText(player.getSettings().getSeason());
        seedLabel.setText(player.getSettings().getSeedType());
        createPlotWater();

        moneyLabel.setText("$" + player.getMoney());
        dateLabel.setText("Day " + this.player.getDay());
        harvestedLabel.setText("0");

        for (int i=5; i>15-player.getMaxPlants(); i--) {
            if (i==5) {
                rect1.setVisible(false);
            }
            if (i==4) {
                rect2.setVisible(false);
            }
            if (i==3) {
                rect3.setVisible(false);
            }
            if (i==2) {
                rect4.setVisible(false);
            }
            if (i==1) {
                rect5.setVisible(false);
            }
        }
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

    public void machinery() {
        if (player.getCounterM() < 1) {
            System.out.println(player.getCounterM());
            player.setCounterM(player.getCounterM()+1);
        } else {
            AlertBoxMachinery.display();
        }
    }
    /**
     * Method that harvests the crop.
     */
    public void harvest() {
        if (player.getCounterM() >= 1) {
            AlertBoxMachinery.display();
            return;
        }
        // Check plots for mature plants
        Button[] plotArray = {plot1, plot2, plot3, plot4, plot5,
            plot6, plot7, plot8, plot9, plot10, plot11, plot12, plot13, plot14, plot15};
        int counter = 0;
        machinery();
        for (Button plot : plotArray) {
            if (player.getPlantArray()[counter] != null
                    && plot.getText().equals(player.getPlantArray()[counter].getName()
                    + ": " + "MATURE_PLANT")) {
                player.setCounterM(player.getCounterM()+1);

                // add to inventory if not full
                player.harvest(player.getPlantArray()[counter]);

                // remove from plant array
                player.getPlantArray()[counter] = null;
                plot.setText("EMPTY");
            }
            counter++;
        }

    }
    /**
     * Method that transitions screen from FarmUI to Market.
     * @param event the Actionevent being handled
     * @throws IOException FileNotFoundException
     */
    public void pressInventory(ActionEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../displays/InventoryUI.fxml"));
        Parent myParent2 = loader2.load();
        ControllerInventory inventory = (ControllerInventory) loader2.getController();
        inventory.setPlayer(this.player);
        loader2.setController(inventory);
        Scene myScene2 = new Scene(myParent2);
        Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window2.setScene(myScene2);
        inventory.setUpWindow();
        window2.show();
    }

    /**
     * get player passed from config ui
     * @return player with settings from config
     */
    public Player getPlayer() {
        return player;
    }

    // TODO; UPDATE EVALUATE PLANT ARRAY METHOD
    /**
     * set new player for game
     * @param player player of farm game
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    @FXML
    public void advanceTime(ActionEvent event) throws Exception {
        // Update day label
        winScreen((Stage) ((Node) event.getSource()).getScene().getWindow());
        endScreen((Stage) ((Node) event.getSource()).getScene().getWindow());
        this.player.setDay(this.player.getDay() + 1);
        dateLabel.setText("Day " + this.player.getDay());

        // Update plant array
        this.player.evaluatePlantArray();
        for (Fertilizer fertilizer : player.getFertilizers()) {
            if (fertilizer.getLevel() >= 0) {
                fertilizer.setLevel(fertilizer.getLevel() - 1);
            }
            int val = fertilizer.getLevel();
            switch (val) {
            case 0:
                fert1.setStyle("-fx-background-color: #efff00;");
                break;
            case 1:
                fert1.setStyle("-fx-background-color: #ff7c00;");
                break;
            case 2:
                fert1.setStyle("-fx-background-color: #ff002a;");
                break;
            case -1:
                fert1.setStyle("-fx-background-color: #bdcabf;");
                break;
            default:
                System.out.println("");
            }
        }

        createPlotWater();
        createEvent();
    }

    /**
     * Method that creates an event.
     */
    public void createEvent() {
        int num = -1;
        int num2 = 0;
        Plant[] temp = player.getPlantArray();
        for (int i = 0; i < 15; i++) {
            if (temp[i] != null && temp[i].getPest()) {
                num2++;
            }
        }
        Random rand = new Random();
        if (player.getSettings().getDifficulty().equals("Easy")) {
            num = rand.nextInt(7);
        } else if (player.getSettings().getDifficulty().equals("Medium")) {
            num = rand.nextInt(6);
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            num = rand.nextInt(5);
        }
        if (num == 0) { //if rain event happens
            num1 = rand.nextInt(5 - 1) + 1;
            for (int i = 0; i < 15; i++) {
                if (player.getPlantArray()[i] != null) {
                    int water = player.getPlantArray()[i].getWaterLevel();
                    temp[i].setWaterLevel(water + num1);
                }
            }
            createPlotWater();
            displayRain();
        } else if (num == 1) {
            num1 = rand.nextInt(5 - 1) + 1;
            for (int i = 0; i < 15; i++) {
                if (player.getPlantArray()[i] != null) {
                    int water = player.getPlantArray()[i].getWaterLevel();
                    temp[i].setWaterLevel(water - num1);
                }
            }
            createPlotWater();
            displayDrought();
        } else if (num == 2) {
            if (player.getSettings().getDifficulty().equals("Easy")) {
                num1 = rand.nextInt(3 - 1) + 1;
                for (int i = 0; i < num1; i++) {
                    if (temp[i] != null && !temp[i].getPest()) {
                        temp[i].setStatus(PlantStatus.DEAD_PLANT);
                    }
                }
            } else if (player.getSettings().getDifficulty().equals("Medium")) {
                num1 = rand.nextInt(5 - 1) + 1;
                for (int i = 0; i < num1; i++) {
                    if (temp[i] != null && !temp[i].getPest()) {
                        temp[i].setStatus(PlantStatus.DEAD_PLANT);
                    }
                }
            } else if (player.getSettings().getDifficulty().equals("Hard")) {
                num1 = rand.nextInt(8 - 1) + 1;
                for (int i = 0; i < num1; i++) {
                    if (temp[i] != null && !temp[i].getPest()) {
                        temp[i].setStatus(PlantStatus.DEAD_PLANT);
                    }
                }
            }
            createPlotWater();
            displayLocust();
        }
    }

    /**
     * Box for if raining.
     */
    public void displayRain() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Invalid Input");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("It's raining! Watering levels increased by " + (num1 - 1));
        label.setId("nameAlertLabel");

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * Method that occurs when drought happens.
     */
    public void displayDrought() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Invalid Input");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("A drought happened! Watering levels decreased by " + (num1 + 1));
        label.setId("nameAlertLabel");

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public void displayLocust() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Invalid Input");
        window.setMinWidth(250);

        Label label = new Label();
        if (num1 - num2 < 0) {
            label.setText("Locusts attacked! There were " + 0 + " crops destroyed!");
            label.setId("nameAlertLabel");
        } else {
            label.setText("Locusts attacked! There were " + (num1 - num2) + " crops destroyed!");
            label.setId("nameAlertLabel");
        }

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    @FXML
    public void plotAction1() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();

            if (plot1.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot1.getText().equals("EMPTY")) {
                temp[0] = seed;
                player.setPlantArray(temp);
            } else {
                int water = player.getPlantArray()[0].getWaterLevel();
                temp[0].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction2() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot2.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot2.getText().equals("EMPTY")) {
                temp[1] = seed;
            } else {
                int water = player.getPlantArray()[1].getWaterLevel();
                temp[1].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction3() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot3.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot3.getText().equals("EMPTY")) {
                temp[2] = seed;
            } else {
                int water = player.getPlantArray()[2].getWaterLevel();
                temp[2].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction4() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot4.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot4.getText().equals("EMPTY")) {
                temp[3] = seed;
            } else {
                int water = player.getPlantArray()[3].getWaterLevel();
                temp[3].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction5() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot5.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot5.getText().equals("EMPTY")) {
                temp[4] = seed;
            } else {
                int water = player.getPlantArray()[4].getWaterLevel();
                temp[4].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction6() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot6.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot6.getText().equals("EMPTY")) {
                temp[5] = seed;
            } else {
                int water = player.getPlantArray()[5].getWaterLevel();
                temp[5].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction7() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot7.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot7.getText().equals("EMPTY")) {
                temp[6] = seed;
            } else {
                int water = player.getPlantArray()[6].getWaterLevel();
                temp[6].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction8() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot8.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot8.getText().equals("EMPTY")) {
                temp[7] = seed;
            } else {
                int water = player.getPlantArray()[7].getWaterLevel();
                temp[7].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction9() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot9.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot9.getText().equals("EMPTY")) {
                temp[8] = seed;
            } else {
                int water = player.getPlantArray()[8].getWaterLevel();
                temp[8].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }
    @FXML
    public void plotAction10() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot10.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot10.getText().equals("EMPTY")) {
                temp[9] = seed;
            } else {
                int water = player.getPlantArray()[9].getWaterLevel();
                temp[9].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction11() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot11.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot11.getText().equals("EMPTY")) {
                temp[10] = seed;
            } else {
                int water = player.getPlantArray()[10].getWaterLevel();
                temp[10].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction12() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot12.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot12.getText().equals("EMPTY")) {
                temp[11] = seed;
            } else {
                int water = player.getPlantArray()[11].getWaterLevel();
                temp[11].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction13() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot13.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot13.getText().equals("EMPTY")) {
                temp[12] = seed;
            } else {
                int water = player.getPlantArray()[12].getWaterLevel();
                temp[12].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction14() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot14.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot14.getText().equals("EMPTY")) {
                temp[13] = seed;
            } else {
                int water = player.getPlantArray()[13].getWaterLevel();
                temp[13].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void plotAction15() {
        if (player.getCounterW() < 10) {
            Plant seed = player.findFirstSeed();
            Plant[] temp = player.getPlantArray();
            if (plot15.getText().equals("EMPTY") && seed == null) {
                System.out.println("Empty inventory");
            } else if (plot15.getText().equals("EMPTY")) {
                temp[14] = seed;
            } else {
                int water = player.getPlantArray()[14].getWaterLevel();
                temp[14].setWaterLevel(water + 1);
                player.setCounterW(player.getCounterW()+1);
            }
            player.setPlantArray(temp);
            createPlotWater();
        } else {
            AlertBoxWater.display();
        }
    }

    @FXML
    public void applyPest1() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[0].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest2() {
        Plant[] temp = player.getPlantArray();
        if (plot2.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[1].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest3() {
        Plant[] temp = player.getPlantArray();
        if (plot3.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[2].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest4() {
        Plant[] temp = player.getPlantArray();
        if (plot4.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[3].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest5() {
        Plant[] temp = player.getPlantArray();
        if (plot5.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[4].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest6() {
        Plant[] temp = player.getPlantArray();
        if (plot6.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[5].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest7() {
        Plant[] temp = player.getPlantArray();
        if (plot7.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[6].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest8() {
        Plant[] temp = player.getPlantArray();
        if (plot8.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[7].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest9() {
        Plant[] temp = player.getPlantArray();
        if (plot9.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[8].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest10() {
        Plant[] temp = player.getPlantArray();
        if (plot10.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[9].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest11() {
        Plant[] temp = player.getPlantArray();
        if (plot11.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[10].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest12() {
        Plant[] temp = player.getPlantArray();
        if (plot12.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[11].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest13() {
        Plant[] temp = player.getPlantArray();
        if (plot13.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[12].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest14() {
        Plant[] temp = player.getPlantArray();
        if (plot14.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[13].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyPest15() {
        Plant[] temp = player.getPlantArray();
        if (plot15.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            temp[14].setPest();
            player.getStock().remove(player.getStock().size() - 1);
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert1() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[0].getFert() < 2) {
                    temp[0].setFert();
                    int val = temp[0].getFert();
                    switch (val) {
                    case 0:
                        fert1.setStyle("-fx-background-color: #efff00;");
                        break;
                    case 1:
                        fert1.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert1.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }
                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert2() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[1].getFert() < 2) {
                    temp[1].setFert();
                    int val = temp[1].getFert();
                    switch (val) {
                    case 0:
                        fert2.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert2.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert2.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert3() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[2].getFert() < 2) {
                    temp[2].setFert();
                    int val = temp[2].getFert();
                    switch (val) {
                    case 0:
                        fert3.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert3.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert3.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert4() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[3].getFert() < 2) {
                    temp[3].setFert();
                    int val = temp[3].getFert();
                    switch (val) {
                    case 0:
                        fert4.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert4.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert4.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert5() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[4].getFert() < 2) {
                    temp[4].setFert();
                    int val = temp[4].getFert();
                    switch (val) {
                    case 0:
                        fert5.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert5.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert5.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert6() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[5].getFert() < 2) {
                    temp[5].setFert();
                    int val = temp[5].getFert();
                    switch (val) {
                    case 0:
                        fert6.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert6.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert6.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert7() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[6].getFert() < 2) {
                    temp[6].setFert();
                    int val = temp[6].getFert();
                    switch (val) {
                    case 0:
                        fert7.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert7.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert2.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert8() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[7].getFert() < 2) {
                    temp[7].setFert();
                    int val = temp[7].getFert();
                    switch (val) {
                    case 0:
                        fert8.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert8.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert8.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert9() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[8].getFert() < 2) {
                    temp[8].setFert();
                    int val = temp[8].getFert();
                    switch (val) {
                    case 0:
                        fert9.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert9.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert9.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert10() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[9].getFert() < 2) {
                    temp[9].setFert();
                    int val = temp[9].getFert();
                    switch (val) {
                    case 0:
                        fert10.setStyle("-fx-background-color: #e9ff00;");
                        break;
                    case 1:
                        fert10.setStyle("-fx-background-color: #ff7c00;");
                        break;
                    case 2:
                        fert10.setStyle("-fx-background-color: #ff002a;");
                        break;
                    default:
                        System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert11() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[10].getFert() < 2) {
                    temp[10].setFert();
                    int val = temp[10].getFert();
                    switch (val) {
                        case 0:
                            fert11.setStyle("-fx-background-color: #e9ff00;");
                            break;
                        case 1:
                            fert11.setStyle("-fx-background-color: #ff7c00;");
                            break;
                        case 2:
                            fert11.setStyle("-fx-background-color: #ff002a;");
                            break;
                        default:
                            System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert12() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[11].getFert() < 2) {
                    temp[11].setFert();
                    int val = temp[11].getFert();
                    switch (val) {
                        case 0:
                            fert12.setStyle("-fx-background-color: #e9ff00;");
                            break;
                        case 1:
                            fert12.setStyle("-fx-background-color: #ff7c00;");
                            break;
                        case 2:
                            fert12.setStyle("-fx-background-color: #ff002a;");
                            break;
                        default:
                            System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert13() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[12].getFert() < 2) {
                    temp[12].setFert();
                    int val = temp[12].getFert();
                    switch (val) {
                        case 0:
                            fert13.setStyle("-fx-background-color: #e9ff00;");
                            break;
                        case 1:
                            fert13.setStyle("-fx-background-color: #ff7c00;");
                            break;
                        case 2:
                            fert13.setStyle("-fx-background-color: #ff002a;");
                            break;
                        default:
                            System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert14() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[13].getFert() < 2) {
                    temp[13].setFert();
                    int val = temp[13].getFert();
                    switch (val) {
                        case 0:
                            fert14.setStyle("-fx-background-color: #e9ff00;");
                            break;
                        case 1:
                            fert14.setStyle("-fx-background-color: #ff7c00;");
                            break;
                        case 2:
                            fert14.setStyle("-fx-background-color: #ff002a;");
                            break;
                        default:
                            System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    @FXML
    public void applyFert15() {
        Plant[] temp = player.getPlantArray();
        if (plot1.getText().equals("EMPTY")) {
            System.out.println("Empty plot");
        } else {
            if (player.getFertilizers().size() < 1) {
                return;
            } else {
                if (temp[14].getFert() < 2) {
                    temp[14].setFert();
                    int val = temp[14].getFert();
                    switch (val) {
                        case 0:
                            fert15.setStyle("-fx-background-color: #e9ff00;");
                            break;
                        case 1:
                            fert15.setStyle("-fx-background-color: #ff7c00;");
                            break;
                        case 2:
                            fert15.setStyle("-fx-background-color: #ff002a;");
                            break;
                        default:
                            System.out.println("");
                    }

                }
                player.getFertilizers().remove(player.getFertilizers().size() - 1);
            }
        }
        player.setPlantArray(temp);
    }
    /**
     * get seed
     * @return seed
     */
    public Plant findFirstSeed() {
        for (Plant plant : this.player.getInventory()) {
            if (plant.getStatus() == PlantStatus.SEED) {
                Plant temp = plant;
                this.player.getInventory().remove(plant);
                return temp;
            }
        }
        return null;
    }

    /**
     * Num1 getter method
     * @return num1
     */
    public int getNum1() {
        return num1;
    }

    @FXML
    public void purchasePlot() {
        if (this.player.getMoney() >= getPlotCost() && this.player.getMaxPlants() != 15) {
            this.player.setMoney(this.player.getMoney() - getPlotCost());
            String rect = "rect" + Integer.toString(this.player.getMaxPlants() - 9);
            if (rect.equals("rect1")) {
                rect1.setVisible(false);
                player.getPlantArray()[10] = null;
            } else if (rect.equals("rect2")) {
                rect2.setVisible(false);
                player.getPlantArray()[11] = null;
            } else if (rect.equals("rect3")) {
                rect3.setVisible(false);
                player.getPlantArray()[12] = null;
            } else if (rect.equals("rect4")) {
                rect4.setVisible(false);
                player.getPlantArray()[13] = null;
            } else if (rect.equals("rect5")) {
                rect5.setVisible(false);
                player.getPlantArray()[14] = null;
            }
            this.player.setMaxPlants(this.player.getMaxPlants() + 1);
            moneyLabel.setText("$" + player.getMoney());
            plotCost.setText(Double.toString(getPlotCost()));
        }
    }

    public double getPlotCost() {
        System.out.println(player.getMaxPlants());
        int m = player.getCounterP();
        return (this.player.getMaxPlants() - 5) * 10.0 * m++;
    }

    /**
     * Method that transitions between farmUi and end.
     * @param event the ActionEvent being handled.
     * @throws IOException Exception that occurs when screen doesn't change properly.
     */
    public void endScreen(Stage event) throws Exception {
        boolean isDead = true;
        Plant[] temp = player.getPlantArray();
        for (Plant a : temp) {
            if (a!= null && a.getStatus() != PlantStatus.DEAD_PLANT) {
                isDead = false;
            }
        }
        if (player.getMoney() < 10 && isDead ) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../displays/EndScreen.fxml"));
            Parent myParent = loader.load();
            Scene myScene = new Scene(myParent);
            Stage window = event;
            window.setScene(myScene);
            window.show();
        }
    }
    /**
     * Method that transitions between farmUi and end.
     * @param event the ActionEvent being handled.
     * @throws IOException Exception that occurs when screen doesn't change properly.
     */
    public void winScreen(Stage event) throws Exception {
        if (player.getMoney() > 700 ) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../displays/WinScreen.fxml"));
            Parent myParent = loader.load();
            Scene myScene = new Scene(myParent);
            Stage window = event;
            window.setScene(myScene);
            window.show();
        }
    }
}

