package edu.hw1;

public class Task8 {

    private Task8() {
    }

    private static final int[] X_MOVES = {1, 1, -1, -1, 2, 2, -2, -2};
    private static final int[] Y_MOVES = {2, -2, 2, -2, 1, -1, 1, -1};
    private static final int FIELD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < FIELD_SIZE; ++i) {
            for (int j = 0; j < FIELD_SIZE; ++j) {
                if (board[i][j] == 0) {
                    continue;
                }

                for (int d = 0; d < X_MOVES.length; ++d) {
                    int xDelta = X_MOVES[d];
                    int yDelta = Y_MOVES[d];
                    int x = i + xDelta;
                    int y = j + yDelta;

                    if (x < 0 || x >= FIELD_SIZE || y < 0 || y >= FIELD_SIZE) {
                        continue;
                    }

                    if (board[x][y] == 1) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
