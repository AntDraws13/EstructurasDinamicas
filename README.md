# Estructuras Dinámicas
Ejercicios para estructura de datos incluyendo listas, pilas, colas y arboles.
Dentro de src/app/ se encunetra el metodo main para declarar los objetos a utilizar

Se hace uso de las clases, atributos y métodos utilizados durante la clase de Estructura de Datos.

## Uso

Se tiene que instanciar un objeto de la Interfaz para hacer uso de los métodos dentro de la case específica. 

````java 
//Nodos
PrintableNode<T> node = new Node(void / T value)
//Listas
Listas<Integer> list = new LinkedLista();
Listas<Integer> list = new DoubleLinkedList(void / T value / long size);
//Pilas
Stacks<Integer> stack = new StackSimpleList(void / T value / int length);
Stacks<Integer> stack = new StackDoubleList(void / T value / int length);
//Colas
Queue<Integer> queue = new QueueArray(Class<T> type | int size);
Queue<Integer> queue = new QueueSimpleList(int size);
Queue<Integer> queue = new QueueDoubleList(int size);
QueueDoubleListPriority<Integer> queue = new QueueDoubleListPriority(int size);
//Arboles 
Tree<Integer> tree = new bTree(T value / Node<T> node);
Tree<Integer> tree = new avlTree(T value);
````

## Métodos

### Nodos:
  
````java
    Node<T> getPrev();

    long getCount();

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
````
### Listas:
````java
    boolean Add(T value);

    boolean Add(Node<T> node);

    boolean AddAtStart(T value);

    boolean AddAtStart(Node<T> node);

    boolean AddAt(int position, T value);

    boolean AddAt(Node<T> value, int position);

    boolean AddAfter(T after, T value);

    boolean AddBefore(T before, T value);

    boolean RemoveAll(T value);

    boolean RemoveBefore(Node<T> node);

    boolean RemoveBefore(T value);

    boolean RemoveAfter(T value);

    boolean Remove(T value);

    boolean Remove(Node<T> node);

    boolean RemoveAtStart() throws isEmptyException;

    Node<T> getElementAt(int value);

    boolean isEmpty() throws isEmptyException;

    long getLength();

    Iterator<T> iterator();
````
### Pilas:
````java
    int getTop();

    int getLength();

    boolean isEmpty() throws isEmptyException;

    boolean isFull() throws isFullException;

    boolean push(T value);

    T pop() throws isEmptyException;

    T peak();

    Listas<T> getPila();
````
### Colas: 
````java
    boolean enqueue(T value);
    
    T dequeue();
    
    boolean removeAll();
    
    void isFull() throws isFullException;
    
    void isEmpty() throws isEmptyException;
    
    T front();
    
    T last();
````
###  Árboles:
````java
    boolean isEmpty() throws isEmptyException;
    
    boolean insert(T value);
    
    boolean insert(Node<T> node);
    
    boolean remove(T value);

    void breadthFirstTraversal();
    
    void printLevel(int level);
    
    Node<T> search (T value) throws isEmptyException;

    T biggest();
    
    T minor();

    void preOrder();
    
    void postOrder();
    
    void inOrder();

    int height();
      
    int heightAsc();
    
    int heightDesc();
      
    int width();
    
    int between(T start, T end);
````
