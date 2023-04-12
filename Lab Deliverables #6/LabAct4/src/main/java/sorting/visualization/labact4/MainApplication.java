package sorting.visualization.labact4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        changeScene("main-view", mainStage);
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String loc, Stage stage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(loc + ".fxml"))));
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }
}