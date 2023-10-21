package edu.hw1;

public class Task8 {

    private Task8() {
    }

    private static final int BOARD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIZE; ++j) {
                if (isCaptureFrom(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] getKnightMoves(int i, int j) {
        return new int[][] {{i + 1, j + 2}, {i + 1, j - 2}, {i - 1, j + 2}, {i - 1, j - 2}, {i + 2, j + 1},
            {i + 2, j - 1}, {i - 2, j + 1}, {i - 2, j - 1}};
    }

    private static boolean isCorrectPosition(int x, int y) {
        return 0 <= x && x < BOARD_SIZE && 0 <= y && y < BOARD_SIZE;
    }

    private static boolean isCaptureFrom(int[][] board, int i, int j) {
        if (board[i][j] == 0) {
            return false;
        }

        for (var move : getKnightMoves(i, j)) {
            int x = move[0];
            int y = move[1];

            if (!isCorrectPosition(x, y)) {
                continue;
            }

            if (board[x][y] == 1) {
                return true;
            }
        }

        return false;
    }
}
