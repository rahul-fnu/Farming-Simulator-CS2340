package farmui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Main method
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method to run on start of app
     * @param primaryStage stage for display for app
     * @throws Exception FileNotFoundException
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("displays/Welcome.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }
}
