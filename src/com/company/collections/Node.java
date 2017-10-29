package com.company.collections;

public class Node<T> {
    private T object;
    private Node<T> prev;
    private Node<T> next;

    public Node() {
        this(null, null, null);
    }

    public Node(T element, Node<T> prev, Node<T> next) {
        this.object = element;
        this.prev = prev;
        this.next = next;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
