import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import javafx.scene.Node;
import farmui.Main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class M2UnitTests extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("displays/Welcome.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    public <T extends Node> T find(final String query) {
        return lookup(query).query();
    }
    @Before
    public void setUp() throws Exception {

    }
    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    public void checkWelcomeToConfigTransition() {
        moveTo("#startGame").clickOn("#startGame");
        Label label = find("#nameID");
        assertThat(label.getText(), is("Enter Player Name!"));
    }
    @Test
    public void checkNameAlert() {
        clickOn("#startGame");
        clickOn("#nameTextField");
        write("");
        clickOn("#nameSubmit");
        Label alertLabel = find("#nameAlertLabel");
        assertThat(alertLabel.getText(), is("Your name can't be null or empty!"));
    }
    @Test
    public void checkDifficultyAlert() {
        clickOn("#startGame");
        clickOn("#difficultySubmit");
        Label alertLabel = find("#difficultyAlertLabel");
        assertThat(alertLabel.getText(), is("Please select a difficulty!"));
    }
    @Test
    public void checkSeedAlert() {
        clickOn("#startGame");
        clickOn("#seedSubmit");
        Label alertLabel = find("#seedAlertLabel");
        assertThat(alertLabel.getText(), is("Please select a seed!"));
    }
    @Test
    public void checkSeasonAlert() {
        clickOn("#startGame");
        clickOn("#seasonSubmit");
        Label alertLabel = find("#seasonAlertLabel");
        assertThat(alertLabel.getText(), is("Please select a season!"));
    }
    @Test
    public void checkConfigtoFarmUITransition() {
        moveTo("#startGame").clickOn("#startGame");
        clickOn("#nameID");
        write("Jignasa Desai");
        clickOn("#nameSubmit");
        clickOn("#menuButtonD");
        clickOn("#medium");
        clickOn("#difficultySubmit");
        clickOn("#menuButtonS");
        clickOn("#apple");
        clickOn("#seedSubmit");
        clickOn("#menuButtonSea");
        clickOn("#fall");
        clickOn("#seasonSubmit");
        clickOn("#continueButton");
        Label label = find("#areaLabel");
        assertEquals(label.getText(), "AREA RESERVED FOR DYNAMIC GAME FUNCTIONALITY");
    }
    @Test
    public void checkNameDataTransfer() {
        moveTo("#startGame").clickOn("#startGame");
        clickOn("#nameID");
        write("Jignasa Desai");
        clickOn("#nameSubmit");
        clickOn("#menuButtonD");
        clickOn("#medium");
        clickOn("#difficultySubmit");
        clickOn("#menuButtonS");
        clickOn("#apple");
        clickOn("#seedSubmit");
        clickOn("#menuButtonSea");
        clickOn("#fall");
        clickOn("#seasonSubmit");
        clickOn("#continueButton");
        Label label = find("#nameLabel");
        assertEquals(label.getText(), "Jignasa Desai");
    }
    @Test
    public void checkDifficultyDataTransfer() {
        moveTo("#startGame").clickOn("#startGame");
        clickOn("#nameID");
        write("Jignasa Desai");
        clickOn("#nameSubmit");
        clickOn("#menuButtonD");
        clickOn("#medium");
        clickOn("#difficultySubmit");
        clickOn("#menuButtonS");
        clickOn("#apple");
        clickOn("#seedSubmit");
        clickOn("#menuButtonSea");
        clickOn("#fall");
        clickOn("#seasonSubmit");
        clickOn("#continueButton");
        Label label = find("#difficultyLabel");
        assertEquals(label.getText(), "Medium");
    }
    @Test
    public void checkSeedDataTransfer() {
        moveTo("#startGame").clickOn("#startGame");
        clickOn("#nameID");
        write("Jignasa Desai");
        clickOn("#nameSubmit");
        clickOn("#menuButtonD");
        clickOn("#medium");
        clickOn("#difficultySubmit");
        clickOn("#menuButtonS");
        clickOn("#apple");
        clickOn("#seedSubmit");
        clickOn("#menuButtonSea");
        clickOn("#fall");
        clickOn("#seasonSubmit");
        clickOn("#continueButton");
        Label label = find("#seedLabel");
        assertEquals(label.getText(), "Apple");
    }
    @Test
    public void checkSeasonDataTransfer() {
        moveTo("#startGame").clickOn("#startGame");
        clickOn("#nameID");
        write("Jignasa Desai");
        clickOn("#nameSubmit");
        clickOn("#menuButtonD");
        clickOn("#medium");
        clickOn("#difficultySubmit");
        clickOn("#menuButtonS");
        clickOn("#apple");
        clickOn("#seedSubmit");
        clickOn("#menuButtonSea");
        clickOn("#fall");
        clickOn("#seasonSubmit");
        clickOn("#continueButton");
        Label label = find("#seasonLabel");
        assertEquals(label.getText(), "Fall");
    }
}