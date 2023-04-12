package quiz.queue.labact3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @brief Controller for the main scene
 */

public class MainViewController implements Initializable {
    /**
     * properties
     */
    protected static MyQueue<Questions> database;
    protected static boolean initialized;


    /**
     * constructors
     */
    public MainViewController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database = new MyQueue<>();
        init();
        initialized = true;
    }

    /**
     * behaviors
     */
    protected void init() {
        String[] presetQuestions = {
                "What is the difference between a stack and a queue?",
                "What type of sorting algorithm has a time complexity of O(n^2)?",
                "What is a binary tree?",
                "What is a hash table used for?",
                "What is a depth-first search (DFS)?"
        };
        String[][] presetAnswers = {
                {
                        "A) A stack is a last-in-first-out (LIFO) data structure, while a queue is a first-in-first-out (FIFO) data structure",
                        "B) A stack is a first-in-first-out (FIFO) data structure, while a queue is a last-in-first-out (LIFO) data structure",
                        "C) A stack and a queue are the same",
                        "D) A stack is a random-access data structure, while a queue is a sequential-access data structure"
                },
                {
                        "A) Quick sort",
                        "B) Merge sort",
                        "C) Bubble sort",
                        "D) Heap sort"
                },
                {
                        "A) A type of linked list",
                        "B) A type of array",
                        "C) A tree data structure where each node can have at most 2 children",
                        "D) A tree data structure where each node can have any number of children"
                },
                {
                        "A) To store and retrieve data with a unique key",
                        "B) To sort data in a specific order",
                        "C) To search for data in a specific order",
                        "D) To retrieve data in random order"
                },
                {
                        "A) A search algorithm that visits all the vertices of a graph in a breadth-first manner",
                        "B) A search algorithm that visits all the vertices of a graph in a depth-first manner",
                        "C) A search algorithm that visits all the vertices of a tree in a breadth-first manner",
                        "D) A search algorithm that visits all the vertices of a tree in a depth-first manner"
                }
        };
        int[] correctAnswers = {1, 3, 3, 1, 1};

        for (int i = 0; i < 5; i++) {
            Questions temp = new Questions(presetQuestions[i], presetAnswers[i], correctAnswers[i]);
            database.push(temp);
        }
    }

    @FXML
    public void exitProg(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void answerQuestions(ActionEvent event) throws IOException {
        MainApp.changeScene(MainApp.getMainStage(), "user-view.fxml");
    }

    @FXML
    public void addQuestions(ActionEvent event) throws IOException {
        MainApp.changeScene(MainApp.getMainStage(), "admin-view.fxml");
    }

    @FXML
    public void userButtonClicked(ActionEvent event) throws URISyntaxException, IOException {
        MainApp.changeScene(MainApp.getMainStage(), "user-view.fxml");
    }

    @FXML
    public void adminButtonClicked(ActionEvent event) throws URISyntaxException, IOException {
        MainApp.changeScene(MainApp.getMainStage(), "admin-view.fxml");
    }
}
