package Stack;

import Excepciones.isEmptyException;
import Excepciones.isFullException;
import List.LinkedLista;
import List.Listas;
import Nodes.Node;

import java.util.Iterator;
import java.util.Scanner;

public class StackSimpleList<T extends Comparable<T>> implements Stacks<T> {

    Listas<T> pila;
    private int length, top;

    public StackSimpleList(){
        pila = new LinkedLista<>();
        this.top = -1;
    }

    public StackSimpleList(int length){
        pila = new LinkedLista<>();
        this.length = length;
        this.top= -1;
    }

    public StackSimpleList(T value){
        Node<T> _new = new Node<>(value);
        pila = new LinkedLista<>(_new);
        this.length = 1;
        this.top = 0;
    }

    @Override
    public Listas<T> getPila() {
        return this.pila;
    }

    @Override
    public int getTop() {
        return this.top;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() throws isEmptyException {
        if(top < 0){
            throw new isEmptyException("Stack is empty");
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() throws isFullException {
        if(top == (length-1)){
            throw new isFullException("Stack is full");
        } else {
            return false;
        }
    }

    @Override
    public boolean push(T value) {
        boolean d1 = true;
        try {
            isFull();
        } catch (isFullException e) {
            System.out.println(e.getMessage());
            d1 = Resize();
        } finally {
            if (d1) Add(value);
        }
        return d1;
    }

    private boolean Resize() {
        System.out.println("Do you want to make it bigger? (s/n) ");
        Scanner in = new Scanner(System.in);
        String opc = in.next();
        if(opc.equals("s") || opc.equals("S")){
            length++;
            return true;
        } else return false;
    }

    private void Add(T value) {
        Node<T> _new = new Node<>(value);
        top++;
        pila.AddAtStart(_new);
    }


    @Override
    public T pop() {
        try {
            isEmpty();
            T pop = pila.getElementAt(0).getValue();
            pila.RemoveAtStart();
            top--;
            return pop;
        } catch (isEmptyException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public T peak() {
        return pila.getElementAt(0).getValue();
    }

    @Override
    public int compareTo(Stacks o) {
        if(o.getLength() == this.length){
            int i =0;
            for (Object o1 : o){
                if(!this.getPila().getElementAt(i).getValue().equals(o.getPila().getElementAt(i).getValue())){
                    if(this.getPila().getElementAt(i).getValue().compareTo((T) o.getPila().getElementAt(i).getValue()) > 0){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                i++;
            }
            return 0;
        } else if (this.length > o.getLength()){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return pila.iterator();
    }

    @Override
    public int compare(Stacks o1, Stacks o2) {
        return o1.compareTo(o2);
    }
}
