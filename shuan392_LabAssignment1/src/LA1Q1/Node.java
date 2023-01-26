package LA1Q1;

public class Node <T>{
    //define fields
    private T element;
    private Node<T> next;

    //define constructor
    public Node(){}

    public Node(T t, Node<T> n) {
        element = t;
        next = n;
    }

    //define methods
    //define getters
    public Node <T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    //define setter
    public void setNext(Node<T> next) {
        this.next = next;
    }


}
