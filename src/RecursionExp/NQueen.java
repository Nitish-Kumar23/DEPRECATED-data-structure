package RecursionExp;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    static int matrixSize=4;

    public static void main(String[] args) {
//        System.out.println(ways(matrixSize));
//        System.out.println(solveNQueens(matrixSize));
        System.out.println(solveNQueensV1(matrixSize));
    }

    static boolean[][] visited = new boolean[][]{
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false},
            {false,false,false,false}
    };
    
    private static int ways(int n) {
        return getQueenWays(0,n);
    }

    private static int getQueenWays(int currentRow, int size) {
        if(currentRow==size){
            printMatrix();
            return 1;
        }
        int count=0;
        for (int col=0;col<size;col++) {
            if (isSafe(currentRow, col)) {
                visited[currentRow][col] = true;
                count += getQueenWays(currentRow + 1, size);
                visited[currentRow][col] = false;
            }
        }
        return count;
    }

    private static void printMatrix() {
        for (int i=0;i<visited.length;i++){
            for (int j=0;j<visited[0].length;j++){
                if(visited[i][j]){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int row, int col) {
        //upwards direction
        for (int i = 0;i<row;i++){
            if (visited[i][col]) 
                return false;
        }
        
        //left diagonal
        int left = Math.min(row,col);
        for (int i=1;left-i>=0;i++){
            if(visited[row-i][col-i]){
                return false;
            }
        }
        
        //right diagonal
        int right = Math.min(row,matrixSize-col-1);
        for (int i=1;right-i>=0;i++){
            if(visited[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static boolean isSafe(int row, int col,boolean[][] matrix) {
        //upwards direction
        for (int i = 0;i<row;i++){
            if (matrix[i][col])
                return false;
        }

        //left diagonal
        int left = Math.min(row,col);
        for (int i=1;left-i>=0;i++){
            if(matrix[row-i][col-i]){
                return false;
            }
        }

        //right diagonal
        int right = Math.min(row,matrix.length-col-1);
        for (int i=1;right-i>=0;i++){
            if(matrix[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> solveNQueens(int n) {
        return solveNQueens(0,n);
    }

    public static List<List<String>> solveNQueensV1(int n) {
        boolean[][] matrix = fillVisitedMatrix(n);
        return solveNQueensV1(0,n,matrix);
    }

    private static List<List<String>> solveNQueensV1(int currentRow, int size, boolean[][] matrix) {
        if(currentRow==size){
            ArrayList<List<String>> list = new ArrayList<>();
            list.add(getQueensPositionV1(matrix));
            return list;
        }
        ArrayList<List<String>> list = new ArrayList<>();
        for (int col=0;col<size;col++) {
            if (isSafe(currentRow, col,matrix)) {
                matrix[currentRow][col] = true;
                list.addAll(solveNQueensV1(currentRow + 1, size,matrix));
                matrix[currentRow][col] = false;
            }
        }
        return list;
    }

    private static boolean[][] fillVisitedMatrix(int n) {
        boolean[][] matrix = new boolean[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=false;
            }
        }
        return matrix;
    }

    private static List<List<String>> solveNQueens(int currentRow, int size) {
        if(currentRow==size){
            ArrayList<List<String>> list = new ArrayList<>();
            list.add(getQueensPosition());
            return list;
        }
        ArrayList<List<String>> list = new ArrayList<>();
        for (int col=0;col<size;col++) {
            if (isSafe(currentRow, col)) {
                visited[currentRow][col] = true;
                list.addAll(solveNQueens(currentRow + 1, size));
                visited[currentRow][col] = false;
            }
        }
        return list;
    }
    
    private static List<String> getQueensPosition(){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<visited.length;i++){
            StringBuilder str = new StringBuilder();
            for (int j=0;j<visited[0].length;j++){
                if(visited[i][j])
                    str.append("Q");
                else 
                    str.append(".");
            }
            list.add(str.toString());
        }
        return list;
    }

    private static List<String> getQueensPositionV1(boolean[][] matrix){
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<matrix.length;i++){
            StringBuilder str = new StringBuilder();
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j])
                    str.append("Q");
                else
                    str.append(".");
            }
            list.add(str.toString());
        }
        return list;
    }
}
