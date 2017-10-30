package com.company.collections;

public class MyHashMap<K,V> {

    private Node<K,V> firstElement;
    private Node<K,V> lastElement;
    private int size = 0;

    // Добавляем пару ключ + значение
    public void put(K key, V value){
        Node<K,V> node = new Node<>(key, value, null);
        if (firstElement == null){
            firstElement = node;
        } else {
            Node<K,V> tempNode = getNode(firstElement, key); // Если getNode вернет null значение указателя last переместиться
            if (tempNode != null) {                          // на новую ноду, иначе у найденой ноды перезапишеться value,
                tempNode.setObjectValue(value);              // a last не изметься
                return;
            }
            lastElement.setNext(node);
        }
        lastElement = node;
        size++;
    }

    public void remove(K key){
        int indexSelected = getIndex(firstElement, key, 0); // Возвращаем индекс удаляемой ноды
        if ((indexSelected == 0) && (key == firstElement.getObjectKey())){
            Node<K,V> first = firstElement.getNext();   // Переопределяем первый указатель
            firstElement.setObjectKey(null);
            firstElement.setObjectValue(null);
            firstElement.setNext(null);
            firstElement = first;
        } else {
            Node<K,V> prev = getNode(firstElement, indexSelected - 1, 0); // Возвращаем предыдущую ноду
            Node<K,V> selected = getNode(firstElement, indexSelected, 0);       // Возвращаем ноду для удаления
            prev.setNext(selected.getNext()); // Переопределяем указатели
            selected.setObjectKey(null);      // Удаляем ноду
            selected.setObjectValue(null);
            selected.setNext(null);
        }
        size--;
    }

    // Очистка списка
    public void clear(){
        for (Node<K,V> x = firstElement; x != null; ){
            Node<K,V> next = x.getNext();
            x.setObjectKey(null);
            x.setObjectValue(null);
            x.setNext(null);
            x = next;
        }
        firstElement = lastElement = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    //Возвращаем значение по ключу
    public V get(K key){
        Node<K,V> node = getNode(firstElement, key);
        if ((node != null) && (node.getObjectValue() != null)){
            return node.getObjectValue();
        }
        return null;
    }

    // Возвращаем ноду по ключу
    private Node<K,V> getNode(Node<K,V> node, K key) {
        Node<K,V> tempNode = node;
        for (int i = 0; i < size; i++){
           if (tempNode.getObjectKey().equals(key)){
               return tempNode;
           } else {
               tempNode = tempNode.getNext();
           }
        }
        return null;
    }

    // Возвращаем ноду по индексу
    private Node<K,V> getNode(Node<K,V> node, int index, int counter) {
        if (index != counter){
            return getNode(node.getNext(), index, counter + 1);
        }
        return node;
    }

    // Возвращаем индекс ноды
    private int getIndex(Node<K,V> node, K key, int index) {
        if (node.getObjectKey() != key){
            return getIndex(node.getNext(), key, index + 1);
        }
        return index;
    }

    private class Node<K,V>{
        private K objectKey;
        private V objectValue;
        private Node<K,V> next;

        public Node(K objectKey, V objectValue, Node<K, V> next) {
            this.objectKey = objectKey;
            this.objectValue = objectValue;
            this.next = next;
        }

        public K getObjectKey() {
            return objectKey;
        }

        public void setObjectKey(K objectKey) {
            this.objectKey = objectKey;
        }

        public V getObjectValue() {
            return objectValue;
        }

        public void setObjectValue(V objectValue) {
            this.objectValue = objectValue;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

}
