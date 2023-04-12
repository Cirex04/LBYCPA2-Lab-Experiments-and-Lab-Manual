package data_structure.labact4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Stage universal_stage;

    @Override
    public void start(Stage stage) throws IOException {
        universal_stage = stage;
        changeScene(universal_stage, "main-view.fxml");
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(Stage stage, String view) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(view)));
        Scene scene = new Scene(root);
        String[] title = view.split("-");
        stage.setResizable(false);
        stage.setTitle(Character.toUpperCase(title[0].charAt(0)) + title[0].substring(1));
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getUniversal_stage() {
        return universal_stage;
    }

    public static void setUniversal_stage(Stage universal_stage) {
        Main.universal_stage = universal_stage;
    }
}