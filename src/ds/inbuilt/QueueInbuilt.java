package ds.inbuilt;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueInbuilt {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new ArrayDeque<>();
        queue.add(12);
        queue.add(145);
        queue.add(10);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }
}
