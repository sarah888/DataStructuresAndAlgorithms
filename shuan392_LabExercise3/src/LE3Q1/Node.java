package LE3Q1;

public class Node <E>{
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E e, Node<E> prev, Node<E> next){}

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }
}
