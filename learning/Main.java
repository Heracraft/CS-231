import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Problem 1 to 5 are conceptual problems.
    // We will set up the programming problems (6 to 10).

    /**
     * Problem 6 — Rotate Queue
     * Write a method that moves the first element of the queue to the back.
     */
    public static void rotateQueue(Queue<Integer> q) {
        // TODO: Implement this method
        Integer x = q.poll();
        q.offer(x);
    }

    /**
     * Problem 7 — Rotate k Positions
     * Write a method that rotates a queue to the left k positions.
     * Example: [1, 2, 3, 4, 5], k = 2 -> Result: [3, 4, 5, 1, 2]
     */
    public static void rotateK(Queue<Integer> q, int k) {
        // TODO: Implement this method
        for (int i = 0; i < k; i++) {
            Integer x = q.poll();
            q.offer(x);
        }

    }

    /**
     * Problem 8 — Sum of Queue
     * Write a method that returns the sum of all elements in the queue.
     */
    public static int sumQueue(Queue<Integer> q) {
        // TODO: Implement this method
        int sum = 0;

        for (int item : q) {
            sum += item;
        }

        return sum;
    }

    /**
     * Problem 9 — Count Even Numbers
     * Write a method that counts how many even numbers appear in a queue.
     */
    public static int countEven(Queue<Integer> q) {
        // TODO: Implement this method
        int noOfEven = 0;

        for (int item : q) {
            if(item%2==0){
                noOfEven++;
            }
        }

        return noOfEven;
    }

    /**
     * Problem 10 — Get Last Element
     * Write a method that returns the last element of the queue.
     * You may only use poll(), offer(), and size().
     */
    public static int getLast(Queue<Integer> q) {
        // TODO: Implement this method

        Integer current=q.peek();

        for(int i=0;i<q.size();i++){
            current=q.poll();
            q.offer(current);
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println("Running Queue Practice Tests...\n");

        // Helper method to create a queue with initial values
        // Note: Using the LinkedList class which implements Queue

        System.out.println("--- Problem 6: Rotate Queue ---");
        Queue<Integer> q6 = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            q6.offer(i);
        System.out.println("Before: " + q6); // Expected: 1 -> 2 -> 3 -> 4 -> 5
        rotateQueue(q6);
        System.out.println("After:  " + q6 + "\n");

        System.out.println("--- Problem 7: Rotate K Positions (k=2) ---");
        Queue<Integer> q7 = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            q7.offer(i);
        System.out.println("Before: " + q7); // Expected: 1 -> 2 -> 3 -> 4 -> 5
        rotateK(q7, 2);
        System.out.println("After:  " + q7 + "\n");

        System.out.println("--- Problem 8: Sum of Queue ---");
        Queue<Integer> q8 = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            q8.offer(i);
        System.out.println("Queue: " + q8);
        System.out.println("Sum:   " + sumQueue(q8) + " (Expected: 15)\n");

        System.out.println("--- Problem 9: Count Even Numbers ---");
        Queue<Integer> q9 = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            q9.offer(i);
        System.out.println("Queue: " + q9);
        System.out.println("Count: " + countEven(q9) + " (Expected: 2)\n");

        System.out.println("--- Problem 10: Get Last Element ---");
        Queue<Integer> q10 = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            q10.offer(i);
        System.out.println("Queue: " + q10);
        System.out.println("Last:  " + getLast(q10) + " (Expected: 5)\n");

    }
}