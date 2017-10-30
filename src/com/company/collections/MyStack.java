package com.company.collections;

public class MyStack<T> extends MyArrayList<T> {

    public MyStack(){
       super();
    }

    public MyStack(int capacity){
        super(capacity);
    }

    // Добавляем элемент в конец
    public void push(T value){
        add(value);
    }

    // Переоределяем методы MyArrayList
    @Override
    public void remove(int index){
        super.remove(index);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public int size() {
        return super.size();
    }

    // Возвращаем первый элемент в стеке (LIFO)
    public Object peek(){
        if (super.get(super.size() - 1) != null){
            return super.get(super.size() - 1);
        }
        return null;
    }

    // Возвращаем первый элемент в стеке (LIFO) и удалям его
    public Object pop(){
        if (super.size() != 0 && super.get(super.size() - 1) != null){
            Object object = super.get(super.size() - 1);
            super.remove(super.size() - 1);
            return object;
        }
        return null;
    }

}
