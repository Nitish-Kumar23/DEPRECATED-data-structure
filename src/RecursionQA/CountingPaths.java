package RecursionQA;

import java.util.ArrayList;

public class CountingPaths {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println(paths(arr,0,0));
        pathsV2(arr,0,0,"");
        System.out.println(pathsV3(arr,0,0,""));
        System.out.println(pathsV4(arr,0,0,""));
    }

    /**
     * return number of paths to reach end of matrix
     * @param arr
     * @param row
     * @param col
     * @return
     */
    private static int paths(int[][] arr,int row,int col) {
        if(row==arr.length-1 || col==arr[0].length-1){
            return 1;
        }
        int count1 = paths(arr,row+1,col);
        int count2 = paths(arr,row,col+1);
        return count1+count2;
    }

    /**
     * 
     * @param arr
     * @param row
     * @param col
     * @param paths
     */
    private static void pathsV2(int[][] arr,int row,int col,String paths) {
        if(row==arr.length-1){
            for (int i=col;i<arr[0].length-1;i++){
                paths = paths+"R";
            }
            System.out.println(paths);
            return;
        }
        if(col==arr.length-1){
            for (int i=row;i<arr.length-1;i++){
                paths = paths+"D";
            }
            System.out.println(paths);
            return;
        }
        pathsV2(arr,row+1,col,paths+"D");
        pathsV2(arr,row,col+1,paths+"R");
    }

    private static ArrayList<String> pathsV3(int[][] arr, int row, int col, String paths) {
        if(row==arr.length-1){
            ArrayList<String> list = new ArrayList<>();
            for (int i=col;i<arr[0].length-1;i++){
                paths = paths+"R";
            }
            list.add(paths);
            return list;
        }
        if(col==arr.length-1){
            ArrayList<String> list = new ArrayList<>();
            for (int i=row;i<arr.length-1;i++){
                paths = paths+"D";
            }
            list.add(paths);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(pathsV3(arr,row+1,col,paths+"D"));
        list.addAll(pathsV3(arr,row,col+1,paths+"R"));
        return list;
    }

    /**
     * return paths to reach end of matrix
     * Down (D),Right (R),Diagonal(DG) but only downward path
     * @param arr
     * @param row
     * @param col
     * @param paths
     * @return
     */
    private static ArrayList<String> pathsV4(int[][] arr, int row, int col, String paths) {
        if(row==arr.length-1){
            ArrayList<String> list = new ArrayList<>();
            for (int i=col;i<arr[0].length-1;i++){
                paths = paths+"R";
            }
            list.add(paths);
            return list;
        }
        if(col==arr.length-1){
            ArrayList<String> list = new ArrayList<>();
            for (int i=row;i<arr.length-1;i++){
                paths = paths+"D";
            }
            list.add(paths);
            return list;
        }
        if(row==arr.length-2 && col==arr.length-2){
            ArrayList<String> list = new ArrayList<>();
            list.add(paths+"RD");
            list.add(paths+"DR"); 
            list.add(paths+"DG");
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(pathsV4(arr,row+1,col,paths+"D"));
        list.addAll(pathsV4(arr,row,col+1,paths+"R"));
        //one more recursion call added if we move diagonally 
        list.addAll(pathsV4(arr,row+1,col+1,paths+"DG"));
        return list;
    }
}
