package RecursionQA;

public class SkipCharacter {
    public static void main(String[] args) {
        System.out.println(skipCharacter("baccad",'a'));
    }

    static StringBuilder result= new StringBuilder();
    private static String skipCharacter(String input, char skipCh) {
        return getSkippedCharacterString(input,skipCh,0,result).toString();
    }

    private static StringBuilder getSkippedCharacterString(String input, char character, int index,StringBuilder result) {
        if(input.length()==index){
            return result;
        }
        if(!(input.charAt(index) == character)){
            result.append(input.charAt(index));
        }
        return getSkippedCharacterString(input,character,index+1,result);
    }
}
