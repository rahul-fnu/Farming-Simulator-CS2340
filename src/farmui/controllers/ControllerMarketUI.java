package farmui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import farmui.models.Player;
import farmui.models.Plant;
import farmui.models.Pesticide;
import farmui.models.Fertilizer;

import java.io.IOException;

public class ControllerMarketUI {
    private Player player;

    @FXML
    private Label moneyLabel = new Label();
    @FXML
    private MenuButton seedMenu;
    @FXML
    private MenuButton itemMenu;
    @FXML
    private MenuButton pesticideMenu;
    private Plant plant;
    private Pesticide pesticide;
    @FXML
    private MenuButton fertilizerMenu;
    private Fertilizer fertilizer;

    private double multiplierBuy = 1;
    private double multiplierSell = 1;
    private double multiplierPest = 1;
    private double multiplierFert = 1;

    /**
     * Method that checks to make sure the market screen is open.
     */
    @FXML
    protected void initialize() {
        System.out.println("Market Screen Open");
    }

    public void setUpWindow() {
        moneyLabel.setText("$" + Double.toString(this.player.getMoney()));
        this.plant = new Plant("", true);
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
     * Method that selects a Cucumber.
     */
    public void selectCucumber() {
        seedMenu.setText("Cucumber");
        this.plant.setName("Cucumber");
        this.plant.setPrice(50);
    }
    /**
     * Method that selects a Bellpepper.
     */
    public void selectBellpepper() {
        seedMenu.setText("Bellpepper");
        this.plant.setName("Bellpepper");
        this.plant.setPrice(60);
    }
    /**
     * Method that selects a Blackberry.
     */
    public void selectBlackberry() {
        seedMenu.setText("Blackberry");
        this.plant.setName("Blackberry");
        this.plant.setPrice(70);
    }
    /**
     * Method that selects a Sunflower.
     * @param event event to select sunflower
     */
    public void selectSunflower(ActionEvent event) {
        seedMenu.setText("Sunflower");
        this.plant.setName("Sunflower");
        this.plant.setPrice(20);
    }
    /**
     * Method that selects a Apple.
     * @param event event to select apple
     */
    public void selectApple(ActionEvent event) {
        seedMenu.setText("Apple");
        this.plant.setName("Apple");
        this.plant.setPrice(30);
    }
    /**
     * Method that selects a Tomato.
     * @param event event to select tomato
     */
    public void selectTomato(ActionEvent event) {
        seedMenu.setText("Tomato");
        this.plant.setName("Tomato");
        this.plant.setPrice(40);
    }
    /**
     * Method that selects a Cucumber.
     */
    public void selectCucumber1() {
        itemMenu.setText("Cucumber");
        this.plant.setName("Cucumber");
        this.plant.setPrice(50);
    }
    /**
     * Method that selects a Bellpepper.
     */
    public void selectBellpepper1() {
        itemMenu.setText("Bellpepper");
        this.plant.setName("Bellpepper");
        this.plant.setPrice(60);
    }
    /**
     * Method that selects a Blackberry.
     */
    public void selectBlackberry1() {
        itemMenu.setText("Blackberry");
        this.plant.setName("Blackberry");
        this.plant.setPrice(70);
    }
    /**
     * Method that selects a Sunflower.
     * @param event event to select sunflower
     */
    public void selectSunflower1(ActionEvent event) {
        itemMenu.setText("Sunflower");
        this.plant.setName("Sunflower");
        this.plant.setPrice(20);
    }
    /**
     * Method that selects a Apple.
     * @param event event to select apple
     */
    public void selectApple1(ActionEvent event) {
        itemMenu.setText("Apple");
        this.plant.setName("Apple");
        this.plant.setPrice(30);
    }
    /**
     * Method that selects a Tomato.
     * @param event event to select tomato
     */
    public void selectTomato1(ActionEvent event) {
        itemMenu.setText("Tomato");
        this.plant.setName("Tomato");
        this.plant.setPrice(40);
    }

    /**
     * Method that submits the seed.
     * @param event the ActionEvent being handled.
     */
    public void submitSeed(ActionEvent event) {

        // Update multipliers based on player difficulty
        if (player.getSettings().getDifficulty().equals("Medium")) {
            System.out.println("medium");
            multiplierBuy = 1.25;
            multiplierSell = 5;
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            System.out.println("hard");
            multiplierBuy = 2;
            multiplierSell = 7;
        }

        // Create new plant object to add to inventory
        Plant seed = new Plant(this.plant.getName(), true);
        seed.setPrice(this.plant.getPrice());

        // Update player's money
        if (player.getInventory().size() != 10 && player.getMoney() >= seed.getPrice()) {
            player.setMoney(player.getMoney() - seed.getPrice() * multiplierBuy);
            moneyLabel.setText("$" + player.getMoney());
            player.getInventory().add(seed);
        } else if (player.getMoney() < seed.getPrice()) {
            System.out.println("Not enough money");
        } else {
            System.out.println("Invenntory full");
        }
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

    /**
     * Method that submits the item that needs to be sold.
     * @param event the Actionevent being handled.
     */
    public void submitItem(ActionEvent event) {

        // Update multipliers based on player difficulty
        if (player.getSettings().getDifficulty().equals("Medium")) {
            System.out.println("medium");
            multiplierBuy = 1.25;
            multiplierSell = 5;
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            System.out.println("hard");
            multiplierBuy = 2;
            multiplierSell = 7;
        }

        // Sell if in inventory
        int counter = 0;
        int toRemove = -1;
        for (Plant crop : player.getInventory()) {
            double cost = ((this.plant.getPrice() + 10) - multiplierSell);
            if (this.plant.getPest()) {
                cost = 0.9 * cost;
            }
            if (crop != null && this.plant.getName().equals(crop.getName())) {
                player.setMoney(player.getMoney()
                        + cost); //selling algo.
                moneyLabel.setText("$" + player.getMoney());
                toRemove = counter;
            }
            counter++;
        }
        if (toRemove >= 0) {
            player.getInventory().remove(toRemove);
        }
    }

    /**
     * Method that selects a Insecticide.
     */
    public void selectInsecticide() {
        pesticideMenu.setText("Insecticide");
        this.pesticide = new Pesticide("Insecticide", 30);
    }

    /**
     * Method that selects a Herbicide.
     */
    public void selectHerbicide() {
        pesticideMenu.setText("Herbicide");
        this.pesticide = new Pesticide("Herbicide", 40);
    }
    /**
     * Method that selects a Rodenticides.
     */
    public void selectRodenticide() {
        pesticideMenu.setText("Rodenticides");
        this.pesticide = new Pesticide("Rodenticides", 50);
    }
    /**
     * Method that selects a Bactericides.
     */
    public void selectBactericide() {
        pesticideMenu.setText("Bactericides");
        this.pesticide = new Pesticide("Bactericides", 60);
    }

    public void submitPesticide(ActionEvent event) {
        // Update multipliers based on player difficulty
        if (player.getSettings().getDifficulty().equals("Medium")) {
            System.out.println("medium");
            multiplierPest = 1.25;
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            System.out.println("hard");
            multiplierPest =  2;
        }

        Pesticide pest = pesticide;
        // Update player's money
        System.out.println(player.getStock());
        if (player.getStock().size() <= 10 && player.getMoney() >= pest.getPrice()) {
            player.setMoney(player.getMoney() - pest.getPrice() * multiplierPest);
            moneyLabel.setText("$" + player.getMoney());
            player.getStock().add(pest);
        } else if (player.getMoney() < pest.getPrice()) {
            System.out.println("Not enough money");
        } else {
            System.out.println("stock full");
        }
    }

    /**
     * Method that selects a Herbicide.
     */
    @FXML
    public void selectOrganic() {
        fertilizerMenu.setText("Organic");
        this.fertilizer = new Fertilizer("Organic", 50, 1);
    }
    /**
     * Method that selects a Rodenticides.
     */
    @FXML
    public void selectNitrogen() {
        fertilizerMenu.setText("Nitrogen");
        this.fertilizer = new Fertilizer("Nitrogen", 35, 1);
    }
    /**
     * Method that selects a Bactericides.
     */
    @FXML
    public void selectPhosphate() {
        fertilizerMenu.setText("Phosphate");
        this.fertilizer = new Fertilizer("Phosphate", 25, 1);
    }
    @FXML
    public void submitFertilizer(ActionEvent event) {
        // Update multipliers based on player difficulty
        if (player.getSettings().getDifficulty().equals("Medium")) {
            System.out.println("medium");
            multiplierFert = 1.25;
        } else if (player.getSettings().getDifficulty().equals("Hard")) {
            System.out.println("hard");
            multiplierFert =  2;
        }
        Fertilizer fert = fertilizer;
        System.out.println(fert);
        System.out.println(player.getFertilizers());
        // Update player's money
        if (player.getFertilizers().size() <= 10 && player.getMoney() >= fert.getPrice()) {
            player.setMoney(player.getMoney() - fert.getPrice() * multiplierFert);
            moneyLabel.setText("$" + player.getMoney());
            player.getFertilizers().add(fert);
        } else if (player.getMoney() < fert.getPrice()) {
            System.out.println("Not enough money");
        } else {
            System.out.println("stock full");
        }
    }
    public void submitIrrigation(ActionEvent event) {
        if (player.getMoney() >= 10) {
            player.setMoney(player.getMoney() - 10); //selling algo.
            player.setCounterW(0);
            moneyLabel.setText("$" + player.getMoney());
        }
    }
    public void submitTractor(ActionEvent event) {
        if (player.getMoney() >= 10) {
            player.setMoney(player.getMoney() - 10); //selling algo.
            moneyLabel.setText("$" + player.getMoney());
            player.setCounterM(0);
        }
    }
    /**
     * Method that transitions screen from MarketUI to Inventory.
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
}
