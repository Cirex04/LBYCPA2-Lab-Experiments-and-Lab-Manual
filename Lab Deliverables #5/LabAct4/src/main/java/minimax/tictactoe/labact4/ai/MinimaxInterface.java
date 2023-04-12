package minimax.tictactoe.labact4.ai;

public interface MinimaxInterface {

    void readBoardState(char[][] board);

    void bestMove();

    int minimax(char[][] board, int depth, boolean isMaximizingPlayer);
}
