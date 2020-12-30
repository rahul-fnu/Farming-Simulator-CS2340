import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
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

import static org.junit.Assert.*;

public class M4UnitTests extends ApplicationTest {
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
    public void checkMaxWater() {
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

        for (int i = 0; i < 10; i++) {
            clickOn("#plot1");
        }
        clickOn("#timeButton");
        Button button = find("#timeButton");
        String text = button.getText();
        assertEquals("Apple: DEAD_PLANT", text);
    }

    @Test
    public void checkWater() {
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

        for (int i = 0; i < 10; i++) {
            clickOn("#plot1");
        }
        Label label = find("#water1");
        String text = label.getText();
        assertEquals("13", text);
    }

    @Test
    public void checkEmpty() {
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
        clickOn("#harvestButton");

        for (int i = 0; i < 10; i++) {
            clickOn("#timeButton");
        }
        Button button = find("#plot1");
        String text = button.getText();
        assertEquals("EMPTY", text);
    }

    @Test
    public void checkEmptyWater() {
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
        clickOn("#harvestButton");

        for (int i = 0; i < 10; i++) {
            clickOn("#timeButton");
        }
        Label label = find("#water1");
        String text = label.getText();
        assertEquals("0", text);
    }

    @Test
    public void checkContinueHarvest() {
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
        clickOn("#timeButton");
        clickOn("#harvestButton");

        int harvested = 0;
        for (int plot = 1; plot <= 10; plot++) {
            String plotName = "#plot" + plot;
            Label label = find(plotName);
            if (label.getText().equals("EMPTY")) {
                harvested++;
            }
        }

        clickOn("#inventoryButton");
        int crops = 1;
        String cropName = "#crop" + crops;
        Label item = find(cropName);
        while (!item.getText().equals("Empty")) {
            crops++;
            cropName = "#crop" + crops;
            item = find(cropName);
        }
        crops--;
        assertEquals(harvested, crops);
    }
}