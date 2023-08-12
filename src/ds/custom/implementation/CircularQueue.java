package ds.custom.implementation;

public class CircularQueue {

    protected int[] input;

    protected int startPointer = 0;
    protected int endPointer = 0;

    public CircularQueue(int minCapacity) {
        this.input = new int[minCapacity];
    }

    public void insert(Integer data) throws Exception {
        if (isFull()) {
            throw new Exception("queue is full");
        }
        endPointer = (endPointer%input.length);
        input[endPointer++] = data;
    }
    
    public Integer removeFront() throws Exception {
        if(isEmpty()){
            throw new Exception("cannot remove from empty queue");
        }
        return input[startPointer++];
    }
    
    public void display(){
        for (int i=startPointer;i<endPointer;i++){
            System.out.print(input[i] + " -> ");
        }
        System.out.println("END");
    }

    protected boolean isEmpty() {
        return startPointer == endPointer;
    }

    protected boolean isFull() {
        return endPointer % input.length + 1 == startPointer; //at last index
    }

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.removeFront();
        queue.display();
    }
}
