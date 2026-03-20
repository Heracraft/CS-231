import java.util.Iterator;

/**
 * Nehemia Kaaya
 * Basic singly LinkedList implementation.
 * Revised to add tail
 * March 4th, 2026
 * CS 231
 *
 * @param <T> A generic type for the elements to bestored in the list
 */
public class LinkedList<T> implements Iterable<T>, Queue<T> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        /**
         * @param element the data to store in this node
         * @param next    the reference to the next node in the list
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        /**
         * @return the element stored in this node
         */
        public E getElement() {
            return element;
        }

        // /**
        //  * @param element the data to set in this node
        //  */
        // public void setElement(E element) {
        //     this.element = element;
        // }

        /**
         * @return the next node in the list
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * @param n the node to be set as the next node
         */
        public void setNext(Node<E> n) {
            this.next = n;
        }

        public String toString() {
            return "%s".formatted(element);
        }
    }

    private class LLIterator implements Iterator<T> {
        private Node<T> next;

        public LLIterator(Node<T> head) {
            this.next = head;
        }

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }

        public T next() {
            T element = this.next.getElement();

            this.next = this.next.next;

            return element;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Initializes an empty linked list.
     */
    public LinkedList() {
        clear();
    }

    /**
     * Constructs a custom iterator
     * 
     * @return the custom iterator
     */

    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Resets the list to be empty.
     */
    public void clear() {
        // should I delete each referenced item? No
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * @return true if the list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an item at the beginning of the list
     * 
     * @param item the element to add
     */
    public void add(T item) {
        Node<T> newNode = new Node<T>(item, null);

        if (this.size() == 0) {
            // head is null
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node<T> current = this.head;

            this.head = newNode;
            newNode.setNext(current);
        }

        this.size++;
    }

    /**
     * inserts the item at the end of the list
     * 
     * @param item the item to be added
     */
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item, null);
        if (this.size() == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }

    /**
     * Adds an item at a specified index.
     * 
     * @param index the position at which to insert the item
     * @param item  the element to be inserted
     */
    public void add(int index, T item) {

        if (index == this.size()) {
            addLast(item);
            return;
        }

        if (this.size() != 0) {
            Node<T> currentNode = this.head;

            Node<T> newNode = new Node<T>(item, null);

            if (index == 0) {
                // special case for when we're adding at the start
                newNode.setNext(this.head);
                this.head = newNode;

            } else {
                int currentIndex = 0;
                while (currentIndex < index - 1) {
                    currentNode = currentNode.getNext();
                    currentIndex++;
                }

                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }

        } else {
            Node<T> newNode = new Node<T>(item, null);
            this.head = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * @param index the position of the element to return
     * @return the element at the specified position
     */
    public T get(int index) {
        if (index == this.size() - 1) {
            return getLast();
        }

        Node<T> currentNode = this.head;

        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
    }

    /**
     * returns the item at the end of the list
     * 
     * @return item
     */
    public T getLast() {
        return this.tail.getElement();
    }

    /**
     * @return the head node of the list
     */
    public Node<T> first() {
        return this.head;
    }

    /**
     * Returns true if o is present in this list, otherwise this method returns
     * false
     * 
     * @param o the object to check for in the list
     * @return true if the list contains the specified object
     */
    public boolean contains(Object o) {
        Node<T> currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getElement().equals(o)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    /**
     * removes the first element of the list
     * 
     * @return the element removed
     */
    public T remove() {
        Node<T> oldHead = this.head;

        this.head = oldHead.getNext();

        this.size--;

        if (this.size == 0) {
            this.tail = null;
        }

        return oldHead.getElement();
    }

    /**
     * Removes the item at index and returns it.
     * 
     * @param index the position at which to remove the item
     * @param item  the element removed
     */
    public T remove(int index) {
        if (this.head == null) {
            throw new NullPointerException("head is null");
        }

        Node<T> currentNode = this.head;
        Node<T> removedNode;

        int currentIndex = 0;
        while (currentIndex < index - 1) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        if (index == 0) {
            // special case for when we're removing the head
            removedNode = this.head;
            this.head = this.head.next;

        } else {
            removedNode = currentNode.next;
            currentNode.next = currentNode.next.next;

        }

        this.size--;
        return removedNode.getElement();
    }

    /**
     * removes the last item of the list and returns it
     * 
     * @return the tail element
     */
    public T removeLast() {
        Node<T> current = this.head;

        while (!current.getNext().equals(this.tail)) {
            // traverse right until the element before the last
            current = current.next;
        }

        this.tail = current;

        this.size--;

        return current.getElement();

    }

    /***
     * returns true if o is a LinkedList that also contains the same items in the
     * same order.
     * 
     * @param 0 linkedList to compare to
     */
    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)) {
            return false;
        } else {
            @SuppressWarnings("unchecked")
            LinkedList<T> l2 = (LinkedList<T>) o;

            Node<T> current1 = this.head;
            Node<T> current2 = l2.head;

            while (current1 != null && current2 != null) {
                if ((current1.next == null && current2.next != null)
                        || (current1.next != null && current2.next == null)) {
                    // one ends faster than the other, not equal.
                    return false;
                } else {
                    if (!current1.getElement().equals(current2.getElement())) {
                        return false;
                    }
                }

                current1 = current1.next;
                current2 = current2.next;
            }

            return true;

        }
    }
    // -------- QUEUE stuff --------

    /**
     * Adds an item to the end of the queue
     */
    public void offer(T item) {
        addLast(item);
    }

    public T peek() {
        if (this.first() != null) {
            return this.first().getElement();
        } else {
            return null;
        }
    }

    public T poll() {
        return this.remove();
    }

    // ---

    /**
     * @return a string representation of the list
     */
    public String toString() {

        String output = "";
        Node<T> currentNode = this.head;

        while (currentNode != null) {
            output += "%s".formatted(currentNode.getElement());

            if (currentNode.next != null) {
                output += " → ";
            }

            currentNode = currentNode.getNext();
        }

        return output;
    }

}
