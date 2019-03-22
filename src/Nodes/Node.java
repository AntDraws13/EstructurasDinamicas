package Nodes;

public class Node<T extends Comparable<T>> {

    private int bf;
    private int height;
    private T value;
    private Node<T> next;
    private Node<T> prev;
    private int count = 0;
    int level;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getText() {
        return value.toString() + "{" + this.getCount() + ", " + this.level + "}";
    }

    public void setRight(Node<T> next) {
        this.next = next;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
