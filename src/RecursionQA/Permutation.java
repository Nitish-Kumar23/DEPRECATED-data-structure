package RecursionQA;

public class Permutation {
    public static void main(String[] args) {
        stringPermutation("abc","");
    }

    private static void stringPermutation(String input,String output) {
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        for (int i=0;i<=output.length();i++){
            String first = output.substring(0,i);
            String last = output.substring(i,output.length());
            stringPermutation(input.substring(1,input.length()),first+input.charAt(0)+last);
        }
    }
}
