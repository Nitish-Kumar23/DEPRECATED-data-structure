package LeetCode;

public class JumpGameII {

    // [2,3,1,1,4]
    // [2,3,0,1,4]
    public static int jumpHelper(int[] arr, int start) {
        if(start==arr.length-1){
            return 0;
        }
        if(arr[start]==0){
            return 0;
        }
        int globalMin = Integer.MAX_VALUE;
        for (int i = start; i < arr[start]+start; i++) {
            int minJump = jumpHelper(arr, i + 1) + 1;
            if (minJump < globalMin) {
                globalMin = minJump;
            }
        }
        return globalMin;
    }

    public static int jump(int[] arr){
        return jumpHelper(arr,0);
    }
    
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

}
