package RecursionQA;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingPaths {
    /**
     * return number of paths to reach end of matrix
     *
     * @param arr
     * @param row
     * @param col
     * @return
     */
    static int[][] output = new int[3][3];
    static boolean[][] flag = new boolean[][]{
            {false,false,false},
            {false,false,false},
            {false,false,false}
    };
    
    public static void main(String[] args) {
        
        int[][] arr = new int[3][3];
//        int[][] maze = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
//        System.out.println(paths(arr, 0, 0));
//        pathsV2(arr, 0, 0, "");
//        System.out.println(pathsV3(arr, 0, 0, ""));
//        System.out.println(pathsV4(arr, 0, 0, ""));
//        pathsWithRestriction(maze, 0, 0, "");
//        pathsWithRestrictionV2(maze, 0, 0, "");
//        pathsV6(arr, 0, 0, "");
        int[][] path = new int[arr.length][arr[0].length];
//        allPathsV1(arr,0,0,"");
        allPrintPaths(arr,0,0,"",path,1);
    }

    private static void pathsWithRestriction(int[][] maze, int row, int col, String output) {
        if (row == maze.length - 1) {
            for (int i = col; i < maze[0].length - 1; i++) {
                if (maze[row][i] == 1) {
                    output = output + "R";
                }
            }
            System.out.println(output);
            return;
        }
        if (col == maze.length - 1) {
            for (int i = row; i < maze.length - 1; i++) {
                if (maze[i][col] == 1) {
                    output = output + "D";
                }
            }
            System.out.println(output);
            return;
        }
        if (maze[row + 1][col] != 0) {
            pathsWithRestriction(maze, row + 1, col, output + "D");
        }
        if (maze[row][col + 1] != 0) {
            pathsWithRestriction(maze, row, col + 1, output + "R");
        }
    }

    private static void pathsWithRestrictionV2(int[][] maze, int row, int col, String output) {
        if (row == maze.length - 1 && col == maze.length - 1) {
            System.out.println(output);
            return;
        }
        if (row < maze.length - 1 && maze[row + 1][col] != 0) {
            pathsWithRestriction(maze, row + 1, col, output + "D");
        }
        if (col < maze[0].length - 1 && maze[row][col + 1] != 0) {
            pathsWithRestriction(maze, row, col + 1, output + "R");
        }
    }

    private static int paths(int[][] arr, int row, int col) {
        if (row == arr.length - 1 || col == arr[0].length - 1) {
            output[row][col] = 1;
            return 1;
        }

        int count1 = output[row + 1][col] != 0 ? output[row + 1][col] : paths(arr, row + 1, col);
        int count2 = output[row][col + 1] != 0 ? output[row][col + 1] : paths(arr, row, col + 1);
        return count1 + count2;
    }

    /**
     * @param arr
     * @param row
     * @param col
     * @param paths
     */
    private static void pathsV2(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1) {
            for (int i = col; i < arr[0].length - 1; i++) {
                paths = paths + "R";
            }
            System.out.println(paths);
            return;
        }
        if (col == arr.length - 1) {
            for (int i = row; i < arr.length - 1; i++) {
                paths = paths + "D";
            }
            System.out.println(paths);
            return;
        }
        pathsV2(arr, row + 1, col, paths + "D");
        pathsV2(arr, row, col + 1, paths + "R");
    }

    private static ArrayList<String> pathsV3(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = col; i < arr[0].length - 1; i++) {
                paths = paths + "R";
            }
            list.add(paths);
            return list;
        }
        if (col == arr.length - 1) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = row; i < arr.length - 1; i++) {
                paths = paths + "D";
            }
            list.add(paths);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(pathsV3(arr, row + 1, col, paths + "D"));
        list.addAll(pathsV3(arr, row, col + 1, paths + "R"));
        return list;
    }

    /**
     * return paths to reach end of matrix
     * Down (D),Right (R),Diagonal(DG) but only downward path
     *
     * @param arr
     * @param row
     * @param col
     * @param paths
     * @return
     */
    private static ArrayList<String> pathsV4(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = col; i < arr[0].length - 1; i++) {
                paths = paths + "R";
            }
            list.add(paths);
            return list;
        }
        if (col == arr.length - 1) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = row; i < arr.length - 1; i++) {
                paths = paths + "D";
            }
            list.add(paths);
            return list;
        }
        if (row == arr.length - 2 && col == arr.length - 2) {
            ArrayList<String> list = new ArrayList<>();
            list.add(paths + "RD");
            list.add(paths + "DR");
            list.add(paths + "DG");
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(pathsV4(arr, row + 1, col, paths + "D"));
        list.addAll(pathsV4(arr, row, col + 1, paths + "R"));
        //one more recursion call added if we move diagonally 
        list.addAll(pathsV4(arr, row + 1, col + 1, paths + "DG"));
        return list;
    }

    private static void pathsV6(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            System.out.println(paths);
            return;
        }
        if (row < arr.length - 1) {
            pathsV6(arr, row + 1, col, paths + "D");
        }
        if (col < arr[0].length - 1) {
            pathsV6(arr, row, col + 1, paths + "R");
        }
    }

    /**
     * if all the directions are allowed
     *
     * @param arr
     * @param row
     * @param col
     * @param paths
     */
    private static void allPaths(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            flag[row][col]=false;
            System.out.println(paths);
            return;
        }
        flag[row][col]=true;
        if (row < arr.length - 1 && flag[row+1][col]==false) {
            allPaths(arr, row + 1, col, paths + "D");
        }
        if (col < arr[0].length - 1 && flag[row][col+1]==false) {
            allPaths(arr, row, col + 1, paths + "R");
        }
        if (row > 0  && flag[row-1][col]==false) {
            allPaths(arr, row - 1, col, paths + "U");
        }
        if (col > 0 && flag[row][col-1]==false) {
            allPaths(arr, row, col - 1, paths + "L");
        }
        flag[row][col]=false;
    }

    private static void allPathsV1(int[][] arr, int row, int col, String paths) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            System.out.println(paths);
            return;
        }
        if(flag[row][col])
            return;
        flag[row][col] = true;
        if (row < arr.length - 1) {
            allPathsV1(arr, row + 1, col, paths + "D");
        }
        if (col < arr[0].length - 1) {
            allPathsV1(arr, row, col + 1, paths + "R");
        }
        if (row > 0 ) {
            allPathsV1(arr, row - 1, col, paths + "U");
        }
        if (col > 0) {
            allPathsV1(arr, row, col - 1, paths + "L");
        }
        flag[row][col]=false;
    }

    private static void allPrintPaths(int[][] arr, int row, int col, String paths,int[][] path,int step) {
        if (row == arr.length - 1 && col == arr.length - 1) {
            path[row][col] = step;
            for (int i=0;i<path.length;i++){
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(paths);
            System.out.println();
            return;
        }
        if(flag[row][col])
            return;
        flag[row][col] = true;
        path[row][col] = step;
        if (row < arr.length - 1) {
            allPrintPaths(arr, row + 1, col, paths + "D",path,step+1);
        }
        if (col < arr[0].length - 1) {
            allPrintPaths(arr, row, col + 1, paths + "R",path,step+1);
        }
        if (row > 0 ) {
            allPrintPaths(arr, row - 1, col, paths + "U",path,step+1);
        }
        if (col > 0) {
            allPrintPaths(arr, row, col - 1, paths + "L",path,step+1);
        }
        flag[row][col]=false;
    }
}
