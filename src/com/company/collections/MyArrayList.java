package com.company.collections;

public class MyArrayList<T> {

    private static final int CAPACITY = 10;     // Начальная емкость списка
    private static final int MULTIPLIER = 3;    // Множитель и делитель для измения
    private static final int DIVIDER = 2;       // размера списка
    private int sizeOfCollection;               // Количество содержащихся обьектов списка
    private Object[] arrayOfObjects;

    public MyArrayList(){
        this(CAPACITY);
    }

    public MyArrayList(int capacity){
        this.arrayOfObjects = new Object[capacity];
    }

    // Добавление элемета
    public void add(T object){
        if (sizeOfCollection == arrayOfObjects.length){
            resize((arrayOfObjects.length * MULTIPLIER ) / DIVIDER);
            arrayOfObjects[sizeOfCollection++] = object;
        } else {
            arrayOfObjects[sizeOfCollection++] = object;
        }
    }

    // Удаление элемента по индексу
    public void remove(int index){
        Object[] tempArray = new Object[arrayOfObjects.length - 1];
        arrayOfObjects[index] = null;
        System.arraycopy(arrayOfObjects, 0, tempArray, 0, index);
        System.arraycopy(arrayOfObjects, index + 1, tempArray, index, tempArray.length - index);
        arrayOfObjects = tempArray;
        sizeOfCollection--;
    }

    // Очистка списка
    public void clear(){
        arrayOfObjects = new Object[CAPACITY];
        sizeOfCollection = 0;
    }

    public int size(){
        return sizeOfCollection;
    }

    // Возвращаем обьект по индексу
    public Object get(int index){
        if(index >= sizeOfCollection || index < 0) {
            return "Неправильный индекс массива!";
        }
        return arrayOfObjects[index];
    }

    // Изменение размера массива
    private void resize(int arrayLength){
        Object[] tempArray = new Object[arrayLength];
        System.arraycopy(arrayOfObjects, 0, tempArray, 0, arrayOfObjects.length);
        arrayOfObjects = tempArray;
    }
}
