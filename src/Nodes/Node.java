package Nodes;

public class Node<T extends Comparable<T>> implements PrintableNode<T> {

    private int bf;
    private int height;
    private T value;
    private Node<T> next;
    private Node<T> prev;
    private long count = 0, level = height;

    public Node() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T value) {
        this.value = value;
    }


    @Override
    public Node<T> getPrev() {
        return prev;
    }


    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public long getLevel() {
        return level;
    }

    @Override
    public void setLevel(long level) {
        this.level = level;
    }

    @Override
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }


    @Override
    public Node<T> getLeft() {
        return prev;
    }

    @Override
    public void setLeft(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public Node<T> getRight() {
        return next;
    }

    @Override
    public String getText() {
        return value.toString()+"{"+this.getCount()+", "+this.height+"}";
    }

    @Override
    public void setRight(Node<T> next) {
        this.next = next;
    }

    @Override
    public int getBf() {
        return bf;
    }

    @Override
    public void setBf(int bf) {
        this.bf = bf;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.level = height;
    }
}
