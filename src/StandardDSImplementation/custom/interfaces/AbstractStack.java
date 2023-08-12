package StandardDSImplementation.custom.interfaces;

public interface AbstractStack<T> extends Iterable<T> {
    
    void push(T element);
    
    T pop();
    
    int size();
    
    boolean isEmpty();
    
    T peek();
    
}
