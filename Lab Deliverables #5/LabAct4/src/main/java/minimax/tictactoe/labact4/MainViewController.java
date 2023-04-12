package minimax.tictactoe.labact4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import minimax.tictactoe.labact4.ai.Minimax;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainViewController implements Initializable, SceneFunctions {
    private final String X_LOC = MainApplication.class.getResource("images/X.png").toURI().toString();
    private final String O_LOC = MainApplication.class.getResource("images/O.png").toURI().toString();
    private char player;
    private char[][] realBoard;
    private Button[][] positions;
    private Minimax ai;

    @FXML
    private Pane mainMenu;
    @FXML
    private GridPane board;
    @FXML
    private Button button00;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22;

    public MainViewController() throws URISyntaxException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        realBoard = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        positions = new Button[3][3];
        positions[0][0] = button00;
        positions[0][1] = button01;
        positions[0][2] = button02;
        positions[1][0] = button10;
        positions[1][1] = button11;
        positions[1][2] = button12;
        positions[2][0] = button20;
        positions[2][1] = button21;
        positions[2][2] = button22;
    }

    /**
     * Prototype
     *
     * @param clickedLoc which location user chose
     * @param xo         if it's 'x' turn or 'o' turn
     */
    @Override
    public void changeGameState(int clickedLoc, String xo) {
        //            switch (clickedLoc) {
//                case 1 -> {
//                    button00.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button00.setMouseTransparent(true);
//                    button00.setOnAction(null);
//                    realBoard[0][0] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 2 -> {
//                    button01.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button01.setMouseTransparent(true);
//                    button01.setOnAction(null);
//                    realBoard[0][1] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 3 -> {
//                    button02.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button02.setMouseTransparent(true);
//                    button02.setOnAction(null);
//                    realBoard[0][2] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 4 -> {
//                    button10.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button10.setMouseTransparent(true);
//                    button10.setOnAction(null);
//                    realBoard[1][0] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 5 -> {
//                    button11.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button11.setMouseTransparent(true);
//                    button11.setOnAction(null);
//                    realBoard[1][1] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 6 -> {
//                    button12.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button12.setMouseTransparent(true);
//                    button12.setOnAction(null);
//                    realBoard[1][2] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 7 -> {
//                    button20.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button20.setMouseTransparent(true);
//                    button20.setOnAction(null);
//                    realBoard[2][0] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 8 -> {
//                    button21.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button21.setMouseTransparent(true);
//                    button21.setOnAction(null);
//                    realBoard[2][1] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                case 9 -> {
//                    button22.setBackground(new Background(new BackgroundImage(new Image(xo),
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundRepeat.NO_REPEAT,
//                            BackgroundPosition.DEFAULT,
//                            BackgroundSize.DEFAULT)));
//                    button22.setMouseTransparent(true);
//                    button22.setOnAction(null);
//                    realBoard[2][2] = (currentTurn == 1 ? 1 : -1);
//                    ai.readBoardState(realBoard);
//                }
//                default -> throw new IllegalStateException("Invalid Click");
//            }
    }

    @Override
    public void changeGameState() {
        if (!board.isDisabled()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (realBoard[i][j] == 'X') {
                        positions[i][j].setBackground(new Background(new BackgroundImage(new Image(X_LOC),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT)));
                        positions[i][j].setMouseTransparent(true);
                        positions[i][j].setOnAction(null);
                    } else if (realBoard[i][j] == 'O') {
                        positions[i][j].setBackground(new Background(new BackgroundImage(new Image(O_LOC),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT)));
                        positions[i][j].setMouseTransparent(true);
                        positions[i][j].setOnAction(null);
                    }
                }
            }

            ai.readBoardState(realBoard);
        }

        System.out.println("Real:");
        System.out.println(Arrays.toString(realBoard[0]));
        System.out.println(Arrays.toString(realBoard[1]));
        System.out.println(Arrays.toString(realBoard[2]));
        System.out.println("Prototype:");
        System.out.println(Arrays.toString(ai.getProto_board()[0]));
        System.out.println(Arrays.toString(ai.getProto_board()[1]));
        System.out.println(Arrays.toString(ai.getProto_board()[2]));
        System.out.println();
        checkGame();
    }

    @FXML
    @Override
    public void buttonPos1(ActionEvent event) {
        //        changeGameState(1, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[0][0] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos2(ActionEvent event) {
        //        changeGameState(2, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[0][1] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos3(ActionEvent event) {
        //        changeGameState(3, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[0][2] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos4(ActionEvent event) {
        //        changeGameState(4, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[1][0] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos5(ActionEvent event) {
        //        changeGameState(5, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[1][1] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos6(ActionEvent event) {
        //        changeGameState(6, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[1][2] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos7(ActionEvent event) {
        //        changeGameState(7, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[2][0] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos8(ActionEvent event) {
        //        changeGameState(8, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[2][1] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void buttonPos9(ActionEvent event) {
        //        changeGameState(9, currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
//        changeGameState(ai.bestMove(), currentTurn == 1 ? X_LOC : O_LOC);
//        currentTurn = (currentTurn == -1 ? 1 : -1);
        realBoard[2][2] = player;
        changeGameState();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void playAsX(ActionEvent event) {
        player = 'X';
        ai = new Minimax(player);
        startGame();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @FXML
    @Override
    public void playAsO(ActionEvent event) {
        player = 'O';
        ai = new Minimax(player);
        startGame();
        ai.bestMove();
        realBoard = ai.getProto_board();
        changeGameState();
    }

    @Override
    public void checkGame() {
        int xWinner = 0;
        int oWinner = 0;

        // check first row
        for (int i = 0; i < 3; i++) {
            if (realBoard[0][i] == 'X') xWinner++;
            else if (realBoard[0][i] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check first column
        for (int i = 0; i < 3; i++) {
            if (realBoard[i][0] == 'X') xWinner++;
            else if (realBoard[i][0] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check second row
        for (int i = 0; i < 3; i++) {
            if (realBoard[1][i] == 'X') xWinner++;
            else if (realBoard[1][i] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check second column
        for (int i = 0; i < 3; i++) {
            if (realBoard[i][1] == 'X') xWinner++;
            else if (realBoard[i][1] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check third row
        for (int i = 0; i < 3; i++) {
            if (realBoard[2][i] == 'X') xWinner++;
            else if (realBoard[2][i] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check third column
        for (int i = 0; i < 3; i++) {
            if (realBoard[i][2] == 'X') xWinner++;
            else if (realBoard[i][2] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check left diagonal
        for (int i = 0; i < 3; i++) {
            if (realBoard[i][i] == 'X') xWinner++;
            else if (realBoard[i][i] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
        xWinner = 0;
        oWinner = 0;

        // check right diagonal
        for (int i = 0; i < 3; i++) {
            if (realBoard[i][2 - i] == 'X') xWinner++;
            else if (realBoard[i][2 - i] == 'O') oWinner++;
        }

        gameEnd(xWinner, oWinner);
    }

    @Override
    public void gameEnd(int xWinner, int oWinner) {
        if (xWinner == 3) {
            System.out.println("x wins");
            board.setDisable(true);
        } else if (oWinner == 3) {
            System.out.println("o wins");
            board.setDisable(true);
        }
    }

    @Override
    public void startGame() {
        mainMenu.setDisable(true);
        mainMenu.setVisible(false);
        board.setDisable(false);
        board.setVisible(true);
    }
}