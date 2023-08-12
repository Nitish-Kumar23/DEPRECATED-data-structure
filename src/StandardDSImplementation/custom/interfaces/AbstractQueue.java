package StandardDSImplementation.custom.interfaces;

/**
 * @author nitishkumar 
 * 
 * @param <T>
 */
public interface AbstractQueue<T> extends Iterable<T> {

    /**
     * 
     * @param element
     */
    void offer(T element);

    /**
     * 
     * @return
     */
    T dequeue();

    /**
     * 
     * @return
     */
    T peek();

    /**
     * 
     * @return
     */
    int size();

    /**
     * 
     * @return
     */
    boolean isEmpty();
    
    void clear();
}
