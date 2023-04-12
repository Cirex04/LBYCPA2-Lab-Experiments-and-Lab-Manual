package tree.visualization.labact3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private MyBSTree<Character> bst;
    private LinkedList<Character> inputList;
    private final int MAX_LEVEL = 4;
    private int level;

    @FXML
    private TextField input;
    @FXML
    private AnchorPane scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bst = new MyBSTree<>();
        inputList = new LinkedList<>();
    }

    @FXML
    public void validateInput(KeyEvent event) {
        if (input.getText().length() != 0) {
            char c = input.getText().charAt(0);
            char validate = '\0';

            if (c <= 122 && c >= 97)
                validate = (char) ((int) c - 32);
            else if (c <= 90 && c >= 65)
                validate = c;
            else {
                try {
                    throw new InputMismatchException("Invalid Input!");
                } catch (InputMismatchException ignored) {
                }
            }

            input.setText(String.valueOf(validate));
        }
    }

    private void generateNode(double moveNodeX, double moveNodeY, char userInput) {
        Circle newNode = new Circle(450 + moveNodeX, 50 + moveNodeY, 25, Color.BLACK);
        Label data = new Label(String.valueOf(userInput));
        data.setTextFill(Color.WHITE);
        data.setPrefSize(250, 250);
        data.setLayoutX(445 + moveNodeX);
        data.setLayoutY(-75 + moveNodeY);
        Line branchLeft = new Line(newNode.getCenterX() - 5, newNode.getCenterY() + 15,
                newNode.getCenterX() - 50, newNode.getCenterY() + 50);
        Line branchRight = new Line(newNode.getCenterX() + 5, newNode.getCenterY() + 15,
                newNode.getCenterX() + 50, newNode.getCenterY() + 50);

        scene.getChildren().add(newNode);
        scene.getChildren().add(data);
        scene.getChildren().add(branchLeft);
        scene.getChildren().add(branchRight);
    }

    private MyBSTree.TreeNode insertLogic(MyBSTree.TreeNode current, char data, double x, double y) {
        if (current == null)
            generateNode(x, y, data);
        else if (data < (char) current.data)
            insertLogic(current.left, data, x - 50, y + 50);
        else if (data > (char) current.data)
            insertLogic(current.right, data, x + 50, y + 50);
        else
            generateNode(x, y, data);

        return current;
    }

    @FXML
    public void insert(ActionEvent event) {
        if (level != MAX_LEVEL) {
            if (input.getText().length() != 0) {
                char userInput = input.getText().charAt(0);
                if (!bst.contains(userInput)) {
                    if (bst.isEmpty()) {
                        bst.insert(userInput);
                        inputList.add(userInput);
                        generateNode(0, 0, userInput);
                    } else {
                        bst.insert(userInput);
                        inputList.add(userInput);
                        insertLogic(bst.root, userInput, 0, 0);
                    }
                }
            }
        }

        input.setText("\0");
    }

    private void deleteLogic(char userInput) {
        for (int i = 0, k = 1; i < inputList.size(); i++, k += 4) {
            if (userInput == 'B') {
                for (int j = 0; j < 4; j++)
                    scene.getChildren().remove(scene.getChildren().get(k));
                generateNode(0, 0, 'A');
                inputList.remove(0);
            } else if (userInput == 'C') {
                for (int j = 0; j < 4; j++)
                    scene.getChildren().remove(scene.getChildren().get(k + 8));
                generateNode(50, 50, 'B');
                inputList.remove(1);
            } else if (userInput == inputList.get(i)) {
                for (int j = 0; j < 4; j++)
                    scene.getChildren().remove(scene.getChildren().get(k));
                inputList.remove(i);
                bst.remove(userInput);
            }
        }
    }

    private Object minValue(MyBSTree.TreeNode root) {
        Object minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }

        return minv;
    }

    @FXML
    public void delete(ActionEvent event) {
        if (level != MAX_LEVEL) {
            if (input.getText().length() != 0) {
                char userInput = input.getText().charAt(0);
                if (bst.contains(userInput)) {
                    deleteLogic(userInput);
                    bst.remove(userInput);
                }
            }
        }

        input.setText("\0");
    }
}