package Nodes;

public interface PrintableNode<T extends Comparable<T>> {
    Node<T> getPrev();

    int getCount();

    void setCount(long count);

    long getLevel();

    void setLevel(long level);

    void setPrev(Node<T> prev);

    Comparable getValue();

    void setValue(T value);

    Node<T> getNext();

    void setNext(Node<T> next);

    Node<T> getLeft();

    void setLeft(Node<T> prev);

    Node<T> getRight();

    String getText();

    void setRight(Node<T> next);

    int getBf();

    void setBf(int bf);

    int getHeight();

    void setHeight(int height);
}
