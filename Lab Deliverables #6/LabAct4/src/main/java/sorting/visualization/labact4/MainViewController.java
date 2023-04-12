package sorting.visualization.labact4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void bubbleSort(ActionEvent event) throws IOException {
        MainApplication.changeScene("bubble-sort", MainApplication.mainStage);
    }

    @FXML
    public void selectionSort(ActionEvent event) throws IOException {
        MainApplication.changeScene("selection-sort", MainApplication.mainStage);
    }
}