package quiz.queue.labact3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller class for admins
 */

public class AdminViewController extends MainViewController {
    /**
     * properties
     */
    @FXML
    private TextArea question;
    @FXML
    private TextField choice;
    @FXML
    private TextField choice1;
    @FXML
    private TextField choice2;
    @FXML
    private TextField choice3;
    @FXML
    private TextField correctChoice;

    /**
     * constructors
     */
    public AdminViewController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * behaviors
     */
    @FXML
    public void submitButton(ActionEvent event) {
        try {
            String[] choices = {
                    choice.getText(),
                    choice1.getText(),
                    choice2.getText(),
                    choice3.getText()
            };
            int correctTemp = switch (correctChoice.getText()) {
                case "A", "a" -> 1;
                case "B", "b" -> 2;
                case "C", "c" -> 3;
                case "D", "d" -> 4;
                default -> throw new RuntimeException("Invalid Input!");
            };

            Questions temp = new Questions(question.getText(), choices, correctTemp);
            database.push(temp);

            question.clear();
            choice.clear();
            choice1.clear();
            choice2.clear();
            choice3.clear();
            correctChoice.clear();
        } catch (RuntimeException e) {
            System.out.println("Invalid input or there's an empty field!");
        }
    }
}
