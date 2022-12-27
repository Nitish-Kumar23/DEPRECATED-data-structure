package StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    private Queue<Integer> firstQueue = new LinkedList<>();
    private Integer top = null;
    public StackUsingQueues(){
        
        
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getTopElement());
        System.out.println(stack.pop());
        System.out.println(stack.getTopElement());
        System.out.println(stack.pop());
        System.out.println(stack.getTopElement());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }

    public void push(int x) {
        firstQueue.add(x);
        top = x;
    }

    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        while (firstQueue.size()>1){
            top = firstQueue.peek();
            temp.add(firstQueue.poll());
        }
        int topElement = firstQueue.poll();
        firstQueue=temp;
        return topElement;
    }

    public int getTopElement() {
        return top;
    }

    public boolean empty() {
        return firstQueue.isEmpty();
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
