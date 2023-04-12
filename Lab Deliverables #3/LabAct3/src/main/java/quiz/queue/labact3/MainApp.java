package quiz.queue.labact3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        changeScene(mainStage, "main-view.fxml");
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(Stage stage, String loc) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApp.class.getResource(loc)));
        Scene scene = new Scene(root);
        String[] title = loc.split("-");
        stage.setResizable(false);
        stage.setTitle(Character.toUpperCase(title[0].charAt(0)) + title[0].substring(1));
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getMainStage() {
        return mainStage;
    }
}