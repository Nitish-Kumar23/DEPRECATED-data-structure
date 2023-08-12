package ds.custom.implementation;

import com.datastructure.dsa.StackException;

import java.util.Arrays;

public class DynamicStack extends StackImplementation{

    public DynamicStack(){
        super();
    }
    
    @Override
    public void push(Integer data) throws StackException {
        if(this.isStackFull()){
            dynamicallyIncreaseArray();
        }
        super.push(data);
    }

    private void dynamicallyIncreaseArray() {
        input = Arrays.copyOf(input,2*input.length);
    }
    
}
