package minimax.tictactoe.labact4.ai;

/**
 * @brief An algorithm to find the maximum benefit from the minimum data
 */

public class Minimax implements MinimaxInterface {
    /**
     * properties
     */
    private char[][] proto_board;
    private static char ai; // AI's role
    private static char player; // Human's role

    /**
     * constructors
     */
    public Minimax(char player) {
        // Initializing a virtual board from the real board in javafx
        proto_board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        // Setting the role of the human
        Minimax.player = player;
        // Setting the role of the AI based from the human's
        ai = (player == 'O' ? 'X' : 'O');
    }

    /**
     * behaviors
     */
    static int evaluate(char[][] b) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2]) {
                if (b[row][0] == ai)
                    return +10;
                else if (b[row][0] == player)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col]) {
                if (b[0][col] == ai)
                    return +10;

                else if (b[0][col] == player)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == ai)
                return +10;
            else if (b[0][0] == player)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == ai)
                return +10;
            else if (b[0][2] == player)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    // Transferring of the real board to the virtual board
    @Override
    public void readBoardState(char[][] board) {
        proto_board = board;
    }

    @Override
    public void bestMove() {
        int best = Integer.MIN_VALUE; // Best Score : for maximizing move
        int[] move = {-1, -1}; // move the ai

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (proto_board[i][j] == ' ') {
                    proto_board[i][j] = ai; // temporary placement in the virtual board
                    int score = minimax(proto_board, 0, false); // minimax algorithm
                    proto_board[i][j] = ' '; // remove temporary data and repeat check

                    if (score > best) { // if score is better set the location as placeholder for ai
                        best = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }

        proto_board[move[0]][move[1]] = ai;
    }

    @Override
    public int minimax(char[][] board, int depth, boolean isMaximizingPlayer) {
        // Check if terminal state
        int score = evaluate(board);
        if (score == 10)
            return score;
        if (score == -10)
            return score;

        if (isMaximizingPlayer) { // if AI
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = ai; // Temporary placement
                        score = minimax(board, depth + 1, false); // Traverse all nodes in the tree
                        board[i][j] = ' ';
                        best = Math.max(score, best);
                    }
                }
            }

            return best;
        } else { // if human
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = player; // Temporary placement for a "pseudo-chosen" move for human player
                        score = minimax(board, depth + 1, true); // Traverse all nodes in the tree
                        board[i][j] = ' ';
                        best = Math.min(score, best);
                    }
                }
            }

            return best;
        }

    }


    public char[][] getProto_board() {
        return proto_board;
    }
}
