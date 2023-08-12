package ds.custom.implementation;

public class CustomQueue {
    
    protected int[] input;

    protected int minCapacity = 10;

    protected int startPointer = 0;

    protected int endPointer = -1;
    
    public CustomQueue(){
        this.input = new int[minCapacity];
    }
    
    public void insert(Integer data) throws Exception {
        if(isFull()){
            throw new Exception("Cannot insert, queue is full");
        }
        input[++endPointer] = data;
    }
    
    public Integer remove() throws Exception {
        if(isEmpty()){
            throw new Exception("cannot pop from empty queue");
        }
        return input[startPointer++];
        
    }
    
    public Integer getFront() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot get front element, queue is empty");
        }
        return input[startPointer];
    }
    
    public void display(){
        for (int  i=startPointer;i<=endPointer;i++){
            System.out.print(input[i] + " -> ");
        }
        System.out.print("END");
    }

    protected boolean isFull() {
        return endPointer == input.length - 1; //at last index
    }

    protected boolean isEmpty() {
        return endPointer == - 1;
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();
        queue.insert(10);
        queue.insert(15);
        queue.insert(42);
        queue.remove();
        queue.display();
        
    }
}

