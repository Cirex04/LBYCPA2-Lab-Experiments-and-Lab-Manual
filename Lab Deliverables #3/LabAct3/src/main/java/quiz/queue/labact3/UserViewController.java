package quiz.queue.labact3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller class for consumers
 */

public class UserViewController extends AdminViewController {
    /**
     * properties
     */
    private int chosenAnswer;
    private Questions initQ;
    @FXML
    private TextArea question;
    @FXML
    private Button a;
    @FXML
    private Button b;
    @FXML
    private Button c;
    @FXML
    private Button d;
    @FXML
    private Label indicator;


    /**
     * constructors
     */
    public UserViewController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chosenAnswer = 0;

        initQ = database.front();

        question.setText(initQ.question());
        a.setText(initQ.multipleChoiceLabel()[0]);
        b.setText(initQ.multipleChoiceLabel()[1]);
        c.setText(initQ.multipleChoiceLabel()[2]);
        d.setText(initQ.multipleChoiceLabel()[3]);
    }

    /**
     * behaviors
     */
    @FXML
    public void submit(ActionEvent event) throws IOException {
        try {
            if (chosenAnswer == initQ.correctAnswer()) {
                indicator.setVisible(true);
                indicator.setText("Correct!");
                indicator.setTextFill(Color.GREEN);
            } else {
                indicator.setVisible(true);
                indicator.setText("Incorrect!");
                indicator.setTextFill(Color.RED);
                database.push(initQ);
            }

            if (initialized)
                database.pop();

            initQ = database.pop();
            question.setText(initQ.question());
            a.setText(initQ.multipleChoiceLabel()[0]);
            b.setText(initQ.multipleChoiceLabel()[1]);
            c.setText(initQ.multipleChoiceLabel()[2]);
            d.setText(initQ.multipleChoiceLabel()[3]);

            initialized = false;
        } catch (RuntimeException ignored) {
            MainApp.changeScene(MainApp.getMainStage(), "main-view.fxml");
            throw new RuntimeException("All questions answered correctly!");
        }
    }

    @FXML
    public void aChosen(ActionEvent event) {
        chosenAnswer = 1;
    }

    @FXML
    public void bChosen(ActionEvent event) {
        chosenAnswer = 2;
    }

    @FXML
    public void cChosen(ActionEvent event) {
        chosenAnswer = 3;
    }

    @FXML
    public void dChosen(ActionEvent event) {
        chosenAnswer = 4;
    }
}
