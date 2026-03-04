// size( ): Returns the number of elements in the list.
// isEmpty( ): Returns true if the list is empty, and false otherwise.
// first( ): Returns (but does not remove) the first element in the list.
// last( ): Returns (but does not remove) the last element in the list.
// addFirst(e): Adds a new element to the front of the list.
// addLast(e): Adds a new element to the end of the list.
// removeFirst( ):

public class LinkedList<T> {

    private static class Node<E>{
        private E element;
        private E next;

        public Node(E element, E next){
            this.element=element;
            this.next=next;
        }

        public E getElement() {
            return element;
        }

        public E getNext() {
            return next;
        }
    }

    private int size;
    private T next;
    private T head;
    private T tail;


    public LinkedList(){
        this.size=0;
        this.next=null;
        this.tail=null;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        if (this.size<0){
            return true;
        }
        else{
            return false;
        }
    }

    public T first(){
        return this.head;
    }
    
}
