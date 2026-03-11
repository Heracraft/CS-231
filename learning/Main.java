import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running LinkedList Practice Problems...");

        LinkedList<Integer> list = new LinkedList<>();
        
        System.out.println("\n--- Testing Empty List ---");
        // System.out.println("Max (expect null): " + max(list));
        // System.out.println("Last (expect null): " + last(list));
        // System.out.println("Count of 5 (expect 0): " + count(list, 5));

        // Add some elements. Remember add(item) inserts at the beginning (stack-like)
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(30);
        
        // Structure: 30 -> 5 -> 20 -> 10
        System.out.println("\n--- Testing Populated List ---");
        System.out.println("List: " + list);
        // Uncomment these as you implement the methods
        // System.out.println("Max (expect 30): " + max(list));
        // System.out.println("Last (expect 10): " + last(list));
        // System.out.println("Count of 10 (expect 1): " + count(list, 10));
        // System.out.println("Adj Equal (expect false): " + hasAdjacentEqual(list));
        // System.out.println("Middle (expect 20 or 5): " + getMiddle(list));

        list.add(30); 
        System.out.println("After adding duplicate at start: " + list);
        // System.out.println("Adj Equal (expect true): " + hasAdjacentEqual(list));

        System.out.println("The max: %s".formatted(max(list)));
        System.out.println("The last: %s".formatted(last(list)));
    }

    /**
     * 1. Find the Maximum Value
     * Return the largest element stored in the list. Assume the elements implement Comparable<E>.
     * Return null if the list is empty.
     */
    public static <E extends Comparable<E>> E max(LinkedList<E> list) {
        // Since Node is an inner class (non-static), we must qualify it with the instance type if we want specific typing,
        // or rely on raw type LinkedList.Node if generic parameters are tricky.
        // However, list.head is accessible here because we are in the same package and head is protected.
        // 
        // Hint: Use `LinkedList<E>.Node` if your compiler allows, or just `var` (Java 10+), 
        //       or cast from raw `LinkedList.Node` to get data.
        
        // Example start:
        // if (list.size() == 0) return null;
        // var current = list.head; // assuming head is accessible
        
        if (list.head == null) return null;
        
        LinkedList.Node currentNode = list.head;

        E max = (E) list.head.getData();

        while(currentNode != null){
            E current = (E) currentNode.getData();
            if (current.compareTo(max) > 0){
                max = current;
            }
            currentNode=currentNode.getNext();
        }

        return max;
    }

    /**
     * 2. Find the Last Element
     * Return the value stored in the final node of the list. Return null if the list is empty.
     */
    public static <E> E last(LinkedList<E> list) {
        LinkedList<E>.Node currentNode =null;
        E last = null;

        if (list.head!=null){
            currentNode=list.head;
        }

        while (currentNode!=null) {
            currentNode=currentNode.getNext();
        }
        
        return currentNode.getData(); // TODO
    }

    /**
     * 3. Count Occurrences
     * Return the number of nodes whose value equals value.
     */
    public static <E> int count(LinkedList<E> list, E value) {
        return 0; // TODO
    }

    /**
     * 4. Detect Adjacent Equal Values
     * Return true if the list contains two adjacent nodes storing equal values. Otherwise return false.
     */
    public static boolean hasAdjacentEqual(LinkedList<?> list) {
        return false; // TODO
    }

    /**
     * 5. Return the Middle Element
     * Return the value stored in the middle node of the list.
     */
    public static <E> E getMiddle(LinkedList<E> list) {
        return null; // TODO
    }
}
