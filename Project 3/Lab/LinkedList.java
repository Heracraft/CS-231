import java.util.Iterator;

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

    public void clear(){
        // should I delete each referenced item?
        this.size=0;
        this.next=null;
        this.tail=null;
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
