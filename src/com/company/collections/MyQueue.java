package com.company.collections;

public class MyQueue<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size = 0;

    // Добавление элемента в конец очереди
    public void add(T value){
        Node<T> node = new Node<>();
        node.setObject(value);
        if (firstElement == null){
            firstElement = node;
        } else {
            lastElement.setNext(node);
        }
        lastElement = node;
        size++;
    }

    // Удаление элемента по индексу
    public void remove(int index) {
        if (index == 0){
            Node<T> first = firstElement.getNext();
            firstElement.setObject(null);
            firstElement.setNext(null);
            firstElement = first;
        } else {
            Node<T> prev = getNode(firstElement, index - 1, 0);
            Node<T> requiredItem = getNode(firstElement, index, 0);
            prev.setNext(requiredItem.getNext());
            requiredItem.setObject(null);
            requiredItem.setNext(null);
        }
        size--;
    }

    // Очистка очереди
    public void clear(){
        for (Node<T> x = firstElement; x != null; ){
            Node<T> next = x.getNext();
            x.setObject(null);
            x.setNext(null);
            x = next;
        }
        firstElement = lastElement = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    // Возвращаем первый элемент в очереди
    public T peek() {
        if (firstElement != null) {
            return firstElement.getObject();
        }
        return null;
    }

    // Возвращаем первый элемент в очереди и удаляем его из коллекции
    public T poll() {
        if (firstElement != null) {
            T object = firstElement.getObject();
            remove(0);
            return object;
        }
        return null;
    }

    // Возвращаем ноду по индексу
    public Node<T> getNode(Node<T> node, int index, int counter) {
        if (index != counter){
            return getNode(node.getNext(), index, counter + 1);
        }
        return node;
    }

}
