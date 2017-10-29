package com.company.collections;

public class MyNode<T> {
    private T element;
    private MyNode<T> prev;
    private MyNode<T> next;

    public MyNode(T element, MyNode<T> prev, MyNode<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}
