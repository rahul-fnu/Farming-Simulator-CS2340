package farmui.alerts;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * AlertBox that pops up if no difficulty is selected.
 */
public class AlertBoxDifficulty {
    /**
     * Method that displays the AlertBox.
     */
    public static void display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Invalid Input");
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("Please select a difficulty!");
        label.setId("difficultyAlertLabel");

        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
