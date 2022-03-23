package RecursionQA;

public class NQueen {
    static int matrixSize=4;

    public static void main(String[] args) {
        System.out.println(ways(matrixSize));
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
}
