package RecursionQA;

public class CountingPaths {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        System.out.println(paths(arr,0,0));
        pathsV2(arr,0,0,"");
    }

    private static int paths(int[][] arr,int row,int col) {
        if(row==arr.length-1 || col==arr[0].length-1){
            return 1;
        }
        int count1 = paths(arr,row+1,col);
        int count2 = paths(arr,row,col+1);
        return count1+count2;
    }

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
}
