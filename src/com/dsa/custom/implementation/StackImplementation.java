package com.dsa.custom.implementation;

import com.datastructure.dsa.StackException;

import java.util.Arrays;

public class StackImplementation {
    
    protected static final int minCapacity = 10;
    
    protected int endPointer = -1;
    
    protected Integer[] input;
    
    public StackImplementation(){
        this.input = new Integer[minCapacity];
    }
    
    public void push(Integer data) throws StackException {
        if(isStackFull()){
            throw new StackException("Stack is full !");
        }
        input[++endPointer] = data;
    }

    protected boolean isStackFull() {
        return endPointer == input.length - 1; //at last index
    }

    private boolean isEmpty() {
        return endPointer == - 1;
    }

    public Integer pop() throws Exception {
        if(isEmpty()){
            throw new StackException("Cannot pop from Empty Stack");
        }
        return input[endPointer--];
    }

    public Integer peek() throws Exception {
        if(isEmpty()){
            throw new StackException("Cannot peek from Empty Stack");
        }
        return input[endPointer];
    }

    public static void main(String[] args) throws Exception {
        StackImplementation stack = new StackImplementation();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
