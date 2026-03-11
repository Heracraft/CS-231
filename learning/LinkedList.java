import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    protected class Node {
        private Node next;
        private T data;

        public Node(T item) {
            this.next = null;
            this.data = item;
        }

        public T getData() {
            return this.data;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public Node getNext() {
            return this.next;
        }
    }

    protected Node head;
    protected int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.getData());
            if (current.getNext() != null) {
                result.append(" -> ");
            }
            current = current.getNext();
        }
        return result.toString();
    }

    public void add(T item) {
        Node newNode = new Node(item);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            add(item);
            return;
        }

        Node current = head;
        // Traverse to the node before the insertion point
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            T data = current.getData();
            if (o == null ? data == null : o.equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return remove();
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        Node nodeToRemove = current.getNext();
        T data = nodeToRemove.getData();
        current.setNext(nodeToRemove.getNext());
        size--;

        return data;
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)) {
            return false;
        }

        LinkedList other = (LinkedList) o;

        if (this.size != other.size()) {
            return false;
        }

        Iterator<T> thisIter = this.iterator();
        Iterator<?> otherIter = other.iterator();

        while (thisIter.hasNext() && otherIter.hasNext()) {
            T thisData = thisIter.next();
            Object otherData = otherIter.next();

            if (thisData == null ? otherData != null : !thisData.equals(otherData)) {
                return false;
            }
        }

        return true;
    }

    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }

    private class LLIterator implements Iterator<T> {
        private Node nextNode;

        public LLIterator(Node head) {
            this.nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T data = nextNode.getData();
            nextNode = nextNode.getNext();
            return data;
        }

        public void remove() {
            // Optional
        }
    }
}
