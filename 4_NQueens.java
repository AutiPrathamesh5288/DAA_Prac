
public class NQueens {

    public static void printSolution(int[][] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;

        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueensUtil(int[][] board, int col) {
        int N = board.length;

        if (col == N) {
            // All queens are placed successfully
            printSolution(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                res = solveNQueensUtil(board, col + 1) || res;

                // If placing queen in the current position doesn't lead to a solution,
                // then remove the queen from the current position (backtrack)
                board[i][col] = 0;
            }
        }

        return res;
    }

    public static void solveNQueens(int N) {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change N to the desired board size
        solveNQueens(N);
    }
}

