package StandardDSImplementation.custom.implementation;

import StandardDSImplementation.custom.interfaces.AbstractStack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class StackLinkedList<T> implements AbstractStack<T>,Iterable<T> {

    private LinkedList<T> list = new LinkedList();
    
    public StackLinkedList(){
        
    }

    /**
     * add first element to the stack
     * 
     * @param element
     */
    public StackLinkedList(T element){
        push(element);
    }


    /**
     * add element to top of the stack - O(1)
     */
    @Override
    public void push(T element) {
            list.add(element);
    }

    /**
     * Removes and returns the top element
     * 
     * @return
     */
    @Override
    public T pop() {
        if(list.isEmpty()){
            throw new EmptyStackException();
        }
        return list.removeLast();
    }

    /**
     * Returns the size of stack
     * 
     * @return
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Checks if the stack is empty
     * 
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /**
     * Peek the top of stack without removing element
     * 
     * @return
     */
    @Override
    public T peek() {
        if(list.isEmpty()){
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StackLinkedList{");
        sb.append(" [ ");
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            T element = iterator.next();
            if(iterator.hasNext()) {
                sb.append(element.toString() + " , ");
            }else
            sb.append(element.toString() + " ] ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        if(useListIterator()) {
            return list.descendingIterator();
        }
        return new StackIterator<>();
    }

    private boolean useListIterator() {
        return true;
    }

    public class StackIterator<T> implements Iterator<T> {

        private int currentIndex = list.size()-1;
        
        @Override
        public boolean hasNext() {
            return currentIndex>=0;
        }

        @Override
        public T next() {
            return (T) list.get(currentIndex--);
        }
    }

    public static void main(String[] args) {
        AbstractStack<Integer> stack = new StackLinkedList<>();
        stack.push(15);
        stack.push(17);
        stack.push(23);
        System.out.println(stack.toString());
        Integer element = stack.peek();
        System.out.println(element);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.toString());
    }
}
