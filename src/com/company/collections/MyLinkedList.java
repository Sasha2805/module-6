package com.company.collections;

public class MyLinkedList<T> {
    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    // Добавление элемета
    public void add(T value){
        Node<T> tempNode = lastElement;
        Node<T> newNode = new Node<>(value, tempNode, null);
        lastElement = newNode;
        if (tempNode == null) {
            firstElement = newNode;
        } else {
            tempNode.setNext(newNode);
        }
        size++;
    }

    // Удаление элемента по индексу
    public void remove(int index){
        Node<T> foundNode = getNode(firstElement, index, 0);
        Node<T> prev = foundNode.getPrev();
        Node<T> next = foundNode.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        foundNode.setPrev(null);
        foundNode.setNext(null);
        foundNode.setObject(null);
        size--;
    }

    // Очистка списка
    public void clear(){
        for (Node<T> x = firstElement; x != null; ) {
            Node<T> next = x.getNext();
            x.setObject(null);
            x.setPrev(null);
            x.setNext(null);
            x = next;
        }
        firstElement = lastElement = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    // Возвращаем элемент ноды по индексу
    public T get(int index){
        if(index >= size || index < 0) {
            return null;
        }
        return getNode(firstElement, index, 0).getObject();
    }

    // Возвращаем ноду по индексу
    public Node<T> getNode(Node<T> node, int index, int counter){
        if (index != counter){
            return getNode(node.getNext(), index, counter + 1);
        }
        return node;
    }
}
