package data_structure.labact4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller for the main view scene
 */

public class MainViewController implements Initializable, Buttons {
    /**
     * properties
     */
    @FXML
    private Button static_array_button;

    /**
     * constructors
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    /**
     * behaviors
     */
    @FXML
    @Override
    public void exit_prog(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    @Override
    public void main_view(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "main-view.fxml");
    }

    @FXML
    @Override
    public void static_array(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "static_array-view.fxml");
    }

    @FXML
    @Override
    public void dynamic_array(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "dynamic_array-view.fxml");
    }

    @FXML
    @Override
    public void singly_linked_list(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "singly_linked_list-view.fxml");
    }

    @FXML
    @Override
    public void doubly_linked_list(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "doubly_linked_list-view.fxml");
    }

    @FXML
    @Override
    public void stack(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "stack-view.fxml");
    }

    @FXML
    @Override
    public void queue(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "queue-view.fxml");
    }

    @FXML
    @Override
    public void binary_search_tree(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "binary_search_tree-view.fxml");
    }

    @FXML
    @Override
    public void hash_table(ActionEvent event) throws IOException {
        Main.changeScene(Main.getUniversal_stage(), "hash_table-view.fxml");
    }
}
