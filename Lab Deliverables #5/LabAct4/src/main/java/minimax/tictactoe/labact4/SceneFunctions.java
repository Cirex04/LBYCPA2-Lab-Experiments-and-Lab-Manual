package minimax.tictactoe.labact4;

import javafx.event.ActionEvent;

import java.net.URISyntaxException;

public interface SceneFunctions {

    void changeGameState(int clickedLoc, String xo);

    void changeGameState();

    void buttonPos1(ActionEvent event) throws URISyntaxException;

    void buttonPos2(ActionEvent event);

    void buttonPos3(ActionEvent event);

    void buttonPos4(ActionEvent event);

    void buttonPos5(ActionEvent event);

    void buttonPos6(ActionEvent event);

    void buttonPos7(ActionEvent event);

    void buttonPos8(ActionEvent event);

    void buttonPos9(ActionEvent event);

    void playAsX(ActionEvent event);

    void playAsO(ActionEvent event);

    void gameEnd(int xWinner, int oWinner);

    void checkGame();

    void startGame();
}
