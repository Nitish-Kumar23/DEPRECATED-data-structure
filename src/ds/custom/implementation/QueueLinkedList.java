package ds.custom.implementation;

import ds.custom.interfaces.AbstractQueue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author nitishkumar 
 * 
 * @param <T>
 */
public class QueueLinkedList<T> implements AbstractQueue<T> {
   
    private final LinkedList<T> list = new LinkedList<>();

    private final int QUEUE_MAX_SIZE;
    
    public QueueLinkedList(T element){
        this.QUEUE_MAX_SIZE = Integer.MAX_VALUE;
        offer(element);
    }
    
    public QueueLinkedList(T element, int maxSize){
        this.QUEUE_MAX_SIZE = maxSize;
        offer(element);
    }
    /**
     * add element to the end of queue (same as 
     * 
     * @param element
     */
    @Override
    public void offer(T element) {
        if(list.size()>=QUEUE_MAX_SIZE){
            throw new RuntimeException("queue max size reached");
        }
        list.add(element);
    }

    /**
     * Removes and returns the front element of the queue (same as poll)
     *
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return list.removeFirst();
    }

    /**
     * Returns the front element of the queue
     * 
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return list.getFirst();
    }

    /**
     * Returns the size of the queue
     * 
     * @return
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * checks if the queue is empty
     * 
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns iterator for the queue
     * 
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
