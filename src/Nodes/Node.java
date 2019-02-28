package Nodes;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }


    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T value) {
        this.value = value;
    }


    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


    public Node<T> getLeft() {
        return prev;
    }

    public void setLeft(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getRight() {
        return next;
    }

    public void setRight(Node<T> next) {
        this.next = next;
    }




}
