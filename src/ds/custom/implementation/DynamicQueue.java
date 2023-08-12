package ds.custom.implementation;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue(int minCapacity) {
        super(minCapacity);
    }
    
    @Override
    public void insert(Integer data) throws Exception {
        if(this.isFull()){
            throw new Exception("queue is full");
        }
        super.insert(data);
    }
}
