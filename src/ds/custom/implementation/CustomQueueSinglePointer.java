package ds.custom.implementation;

public class CustomQueueSinglePointer extends CustomQueue{
    
    public CustomQueueSinglePointer(){
        super();
    }
    
    @Override
    public Integer remove() throws Exception {
        if(isEmpty()){
            throw new Exception("cannot pop from empty queue");
        }
        
        int removed = input[0];
        
        //shift all elements to left by 1
        for (int i=1;i<endPointer;i++){
            input[i-1] = input[i];
        }
        endPointer--;
        return removed;
    }

    @Override
    public Integer getFront() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot get front element, queue is empty");
        }
        return input[0];
    }
}
