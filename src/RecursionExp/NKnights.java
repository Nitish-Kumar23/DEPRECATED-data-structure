package RecursionExp;

public class NKnights {
    public static void main(String[] args) {
        System.out.println(nKnights(4));
    }

    private static int nKnights(int size) {
        boolean[][] matrix = fillVisitedMatrix(size);
        return nKnights(0, 0, size, matrix);
    }

    private static int nKnights(int currentRow, int currentCol, int activeKnights, boolean[][] matrix) {
        if (activeKnights == 0)
            return 1;
        if (currentRow == matrix.length && currentCol == matrix[0].length) {
            return 0;
        }
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (isSafe(row, currentCol, matrix)) {
                matrix[row][currentCol] = true;
                count += nKnights(row, currentCol + 1, --activeKnights, matrix);
                matrix[currentRow][currentCol] = false;
            }
        }
        for (int col = 0; col < matrix[0].length; col++) {
            if (isSafe(currentRow, col, matrix)) {
                matrix[currentCol][col] = true;
                count += nKnights(currentRow+1, col, --activeKnights, matrix);
                matrix[currentRow][currentCol] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(int row, int col, boolean[][] matrix) {
        if (row - 1 >= 0 && col + 2 < matrix[0].length && matrix[row - 1][col + 2]) {
            return false;
        }
        if (row + 1 < matrix.length && col + 2 < matrix[0].length && matrix[row + 1][col + 2]) {
            return false;
        }
        if (row - 1 >= 0 && col - 2 >= 0 && matrix[row - 1][col - 2]) {
            return false;
        }
        if (row + 1 < matrix.length && col - 2 >= 0 && matrix[row + 1][col - 2]) {
            return false;
        }
        if (row - 2 >= 0 && col + 1 < matrix[0].length && matrix[row - 2][col + 1]) {
            return false;
        }
        if (row - 2 >= 0 && col - 1 < matrix[0].length && matrix[row - 2][col - 1]) {
            return false;
        }
        if (row + 2 < matrix.length && col + 1 < matrix[0].length && matrix[row + 2][col + 1]) {
            return false;
        }
        return row + 2 >= matrix.length || col - 1 < 0 || !matrix[row + 2][col - 1];
    }

    private static boolean[][] fillVisitedMatrix(int n) {
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = false;
            }
        }
        return matrix;
    }

}
