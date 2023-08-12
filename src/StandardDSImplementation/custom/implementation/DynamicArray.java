package StandardDSImplementation.custom.implementation;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    
    
    private int ARRAY_SIZE_INCREMENT_FACTOR=10;
    
    private T[] arr;
    
    int currentPosition=0;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        arr = (T[]) new Object[ARRAY_SIZE_INCREMENT_FACTOR];
    }
    
    public void add(T element){
        if(currentPosition<arr.length){
            arr[currentPosition++] = element;
            return;
        }
        incrementArraySize();
        arr[currentPosition++] = element;
    }

    private void incrementArraySize() {
        T[] tempArray = Arrays.copyOf(arr,2*ARRAY_SIZE_INCREMENT_FACTOR);
        arr = tempArray;
    }
    
    public int search(T element){
        for (int i=0;i<arr.length;i++){
            if(arr[i]==element)
                return i;
        }
        // element not found
        return -1;
    }
    
    public void remove(T element){
        int index = search(element);
        for (int i=index+1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
    }

    public void removeElementByIndex(int index){
        if(index<0 || index>=currentPosition){
            throw new IndexOutOfBoundsException();
        }
        for (int i=index+1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
    }

    public void insertAtIndex(T element,int index){
        if(index<0 || index>=currentPosition){
            throw new IndexOutOfBoundsException();
        }
        if(currentPosition>=arr.length){
            incrementArraySize();
        }
        for (int i=arr.length-1;i>index;i--){
            arr[i]=arr[i-1];
        }
        arr[index] = element;   
    }
    
    public int size(){
        return currentPosition+1;
    }
    
    public int capacity(){
        return arr.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DynamicArray{");
        sb.append(", arr=").append(Arrays.toString(arr));
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args){
        DynamicArray array = new DynamicArray();
        array.add(10);
        array.add(15);
        array.add(20);
        array.add(10);
        array.add(15);
        array.add(20);
        array.add(10);
        array.add(15);
        array.add(20);
        array.add(10);
        array.add(15);
        array.add(20);
        System.out.println(array);
        array.remove(15);
        System.out.println(array);
        System.out.println(array.search(15));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0; 
            
            @Override
            public boolean hasNext() {
                return currentIndex<currentPosition && arr[currentIndex]!=null;
            }

            @Override
            public T next() {
                return arr[currentIndex++];
            }
        };
    }
}
