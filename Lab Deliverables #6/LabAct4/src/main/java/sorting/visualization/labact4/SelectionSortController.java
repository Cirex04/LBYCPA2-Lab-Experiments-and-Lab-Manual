package sorting.visualization.labact4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller class for the selection sort view
 */

public class SelectionSortController extends BubbleSortController {
    /**
     * properties
     */
    private int[] data;

    /**
     * constructors
     */
    public SelectionSortController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        data = new int[]{Integer.parseInt(block1.getText()),
                Integer.parseInt(block2.getText()),
                Integer.parseInt(block3.getText()),
                Integer.parseInt(block4.getText()),
                Integer.parseInt(block5.getText()),
                Integer.parseInt(block6.getText())
        };

        selectionSort();
    }

    /**
     * behaviors
     */
    private void selectionSort() {
        int min = searchMinimum(data, data.length);
        // colors
        // #dc143c - minimum
        // #add8e6 - revert to original bg
        // #008000 - highlight

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> block1.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(2), event -> block2.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(3), event -> block1.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(3), event -> block2.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(3), event -> block3.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(4), event -> block3.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(4), event -> block4.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(5), event -> block2.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(5), event -> block4.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(5), event -> block5.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(6), event -> block5.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(6), event -> block6.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(7), event -> block6.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(7), event -> swap(block1, block4)),
                new KeyFrame(Duration.seconds(9.5), event -> block2.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(10.5), event -> block3.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(11.5), event -> block3.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(11.5), event -> block4.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(12.5), event -> block4.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(12.5), event -> block5.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(13.5), event -> block5.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(13.5), event -> block6.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(14.5), event -> block6.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(14.5), event -> block2.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(14.5), event -> block3.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(15.5), event -> block4.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(16.5), event -> block3.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(16.5), event -> block4.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(16.5), event -> block5.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(17.5), event -> block5.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(17.5), event -> block6.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(18.5), event -> block6.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(18.5), event -> swap(block3, block4)),
                new KeyFrame(Duration.seconds(21.5), event -> block4.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(22.5), event -> block5.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(23.5), event -> block5.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(23.5), event -> block6.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(24.5), event -> block6.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(24.5), event -> block4.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(25.5), event -> block5.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(26.5), event -> block6.setStyle("-fx-background-color: #008000;")),
                new KeyFrame(Duration.seconds(27.5), event -> block5.setStyle("-fx-background-color: #add8e6;")),
                new KeyFrame(Duration.seconds(27.5), event -> block6.setStyle("-fx-background-color: #dc143c;")),
                new KeyFrame(Duration.seconds(28), event -> swap(block5, block6))
        );

        timeline.play();
    }

    private int searchMinimum(int[] arr, int n) {
        if (n == 1)
            return arr[0];

        int min = searchMinimum(arr, n - 1);

        return Math.min(min, arr[n - 1]);
    }
}
