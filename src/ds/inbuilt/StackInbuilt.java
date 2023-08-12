package ds.inbuilt;

import java.util.Stack;

public class StackInbuilt {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(31);
        stack.push(42);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
