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

import static org.junit.Assert.*;

public class M6UnitTests extends ApplicationTest {
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
    public void checkHarvestMax() {
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

    @Test
    public void checkWaterMax() {
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
        clickOn("#marketButton");

        clickOn("#seedMenu");
        clickOn("#selectAppleSeed");
        clickOn("#submitSeed");

        clickOn("#inventoryButton");
        Label label = find("#seed1");
        assertEquals("Apple", label.getText());
    }

    @Test
    public void checkPlotExpansion() {
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

        clickOn("#marketButton");
        for (int i = 0; i < crops; i++) {
            clickOn("#itemMenu");
            clickOn("#selectApple");
            clickOn("#submitItem");
        }

        clickOn("#inventoryButton");
        Label label = find("#crop1");
        assertEquals("Empty", label.getText());
    }

    @Test
    public void checkEndScreen() {
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


        clickOn("#marketButton");
        Label money = find("#moneyLabel");
        String str1 = money.getText();
        for (int i = 0; i < crops; i++) {
            clickOn("#itemMenu");
            clickOn("#selectApple");
            clickOn("#submitItem");
        }
        String str2 = money.getText();
        if (crops > 0) {
            assert (Double.parseDouble(str1.replace("$", ""))
                    < Double.parseDouble(str2.replace("$", "")));
        } else {
            assert (Double.parseDouble(str1.replace("$", ""))
                    == Double.parseDouble(str2.replace("$", "")));
        }
    }

    @Test
    public void checkWinScreen() {
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
        clickOn("#marketButton");

        Label money = find("#moneyLabel");
        String str1 = money.getText();
        clickOn("#seedMenu");
        clickOn("#selectAppleSeed");
        clickOn("#submitSeed");
        String str2 = money.getText();
        assert (Double.parseDouble(str1.replace("$", ""))
                > Double.parseDouble(str2.replace("$", "")));
    }
}