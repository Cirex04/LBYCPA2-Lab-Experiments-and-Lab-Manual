package sorting.visualization.labact4;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller for the bubble sort view
 */

public class BubbleSortController implements Initializable {
    /**
     * properties
     */
    protected boolean isSwap;

    @FXML
    protected Button block1;
    @FXML
    protected Button block2;
    @FXML
    protected Button block3;
    @FXML
    protected Button block4;
    @FXML
    protected Button block5;
    @FXML
    protected Button block6;


    /**
     * constructors
     */
    public BubbleSortController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, event -> check(block1, block2)),
                new KeyFrame(Duration.seconds(2.5), event -> check(block2, block3)),
                new KeyFrame(Duration.seconds(5), event -> check(block3, block4)),
                new KeyFrame(Duration.seconds(7.5), event -> check(block4, block5)),
                new KeyFrame(Duration.seconds(10), event -> check(block5, block6)),
                new KeyFrame(Duration.seconds(12.5), event -> check(block1, block2)),
                new KeyFrame(Duration.seconds(15), event -> check(block2, block3)),
                new KeyFrame(Duration.seconds(17.5), event -> check(block3, block4)),
                new KeyFrame(Duration.seconds(20), event -> check(block4, block5)),
                new KeyFrame(Duration.seconds(22.5), event -> check(block5, block6)),
                new KeyFrame(Duration.seconds(25), event -> check(block1, block2)),
                new KeyFrame(Duration.seconds(27.5), event -> check(block2, block3)),
                new KeyFrame(Duration.seconds(30), event -> check(block3, block4)),
                new KeyFrame(Duration.seconds(32.5), event -> check(block4, block5)),
                new KeyFrame(Duration.seconds(35), event -> check(block5, block6)),
                new KeyFrame(Duration.seconds(37.5), event -> check(block1, block2))
        );

        timeline.play();
    }

    /**
     * behaviors
     */
    protected void check(Button button, Button button1) {
        String valueOfX = button.getText();
        String valueOfY = button1.getText();

        isSwap = Integer.parseInt(valueOfX) > Integer.parseInt(valueOfY);

        if (!isSwap) {
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), new KeyValue(button.styleProperty(), "-fx-background-color: #008000;")),
                    new KeyFrame(Duration.seconds(2.25), new KeyValue(button.styleProperty(), "-fx-background-color:  #add8e6;")),
                    new KeyFrame(Duration.seconds(1), new KeyValue(button1.styleProperty(), "-fx-background-color: #008000;")),
                    new KeyFrame(Duration.seconds(2.25), new KeyValue(button1.styleProperty(), "-fx-background-color:  #add8e6;"))
            );
            timeline.play();
        } else
            swap(button, button1);
    }

    protected void swap(Button button, Button button1) {
        String valueOfX = button.getText();
        String valueOfY = button1.getText();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), new KeyValue(button.styleProperty(), "-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(2.25), new KeyValue(button.styleProperty(), "-fx-background-color:  #add8e6;")),
                new KeyFrame(Duration.seconds(1), new KeyValue(button1.styleProperty(), "-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(2.25), new KeyValue(button1.styleProperty(), "-fx-background-color:  #add8e6;")),
                new KeyFrame(Duration.seconds(2.25), new KeyValue(button.textProperty(), valueOfY)),
                new KeyFrame(Duration.seconds(2.25), new KeyValue(button1.textProperty(), valueOfX))
        );

        timeline.play();
    }

    @FXML
    public void backToMenu(ActionEvent event) throws IOException {
        MainApplication.changeScene("main-view", MainApplication.mainStage);
    }
}
