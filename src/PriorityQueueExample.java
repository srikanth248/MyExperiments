import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        // Creating empty priority queue
        PriorityQueue<String> pQueue = new PriorityQueue<String>();

        // Adding items to the pQueue using add()
        pQueue.add("A");
        pQueue.add("C");
        pQueue.add("E");
        pQueue.add("B");
        pQueue.add("G");
        pQueue.add("H");
        pQueue.add("F");
        pQueue.add("D");

        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }

        pQueue.add("A");
        pQueue.add("C");
        pQueue.add("E");
        pQueue.add("B");
        pQueue.add("G");
        pQueue.add("H");
        pQueue.add("F");
        pQueue.add("D");

        Object[] objects = pQueue.toArray();

        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);

        Object[] nums = minHeap.toArray();

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
