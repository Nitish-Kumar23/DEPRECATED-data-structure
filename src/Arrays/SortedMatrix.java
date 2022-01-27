package Arrays;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5}, 
                {6, 7, 8, 9, 10}, 
                {11, 12, 13, 14, 15}, 
                {16, 17, 18, 19, 20}
        };
        System.out.println(Arrays.toString(getElementPosition(matrix, 19)));
    }

    private static int[] getElementPosition(int[][] matrix, int target) {
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        int midCol = (colStart + colEnd) / 2;
        int[] res = {-1, -1};
        while (rowStart < rowEnd && colStart < colEnd) {
            //keep mid column constant but keep halving rows and reduce the search space
            int midRow = (rowStart + rowEnd) / 2;
            if (matrix[midRow][midCol] == target) {
                return new int[]{midRow, midCol};
            } else if (matrix[midRow][midCol] < target) {
                rowStart = midRow;
            } else if (matrix[midRow][midCol] > target) {
                rowEnd = midRow;
            }
            //if only two rows are there binary search in 4 different arrays which is connected by middle column element
            if (rowEnd == rowStart + 1) {
                //search in first half
                if (matrix[rowEnd][midCol - 1] >= target && matrix[rowEnd][colStart] <= target) {
                    res = binarySearch(matrix, rowEnd, colStart, midCol, target);
                }
                //search in second half
                if (matrix[rowEnd][midCol + 1] <= target && matrix[rowEnd][colEnd] >= target) {
                    res = binarySearch(matrix, rowEnd, midCol + 1, colEnd, target);
                }
                //search in third half
                if (matrix[rowStart][midCol - 1] >= target && matrix[rowStart][colStart] <= target) {
                    res = binarySearch(matrix, rowStart, colStart, midCol, target);
                }
                //search in remaining array
                if (matrix[rowStart][midCol + 1] <= target && matrix[rowStart][colEnd] >= target) {
                    res = binarySearch(matrix, rowStart, midCol + 1, colEnd, target);
                }
                return res;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] binarySearch(int[][] matrix, int row, int colStart, int colEnd, int target) {
        int mid = colStart + (colEnd - colStart) / 2;
        while (colStart < colEnd) {
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            } else if (matrix[row][mid] < target) {
                colStart = mid + 1;
            } else if (matrix[row][mid] > target) {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
