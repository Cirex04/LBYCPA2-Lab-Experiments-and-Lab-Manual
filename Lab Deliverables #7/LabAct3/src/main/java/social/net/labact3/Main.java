package social.net.labact3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D screen = Screen.getPrimary().getBounds();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainview.fxml")));
        primaryStage.setTitle("Social Net");
        primaryStage.setScene(new Scene(root, 0.8 * screen.getWidth(), 0.8 * screen.getHeight()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
