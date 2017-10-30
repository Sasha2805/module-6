package com.company;

import com.company.collections.*;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("one");
        myArrayList.add("two");
        myArrayList.add("three");
        System.out.println(myArrayList.size());
        myArrayList.remove(0);
        System.out.println(myArrayList.get(0));
        myArrayList.clear();
        System.out.println(myArrayList.size());
        System.out.println("--------------------------------");


        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("one");
        myLinkedList.add("two");
        myLinkedList.add("three");
        myLinkedList.add("four");
        myLinkedList.add("five");
        System.out.println(myLinkedList.get(1));
        myLinkedList.remove(3);
        myLinkedList.clear();
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.size());
        System.out.println("--------------------------------");


        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("one");
        myQueue.add("two");
        myQueue.add("three");
        myQueue.add("four");

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        myQueue.remove(0);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
        myQueue.clear();
        System.out.println(myQueue.size());
        System.out.println("--------------------------------");


        MyStack<String> myStack = new MyStack<>();
        myStack.push("one");
        myStack.push("two");
        myStack.push("three");
        myStack.push("four");

        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        myStack.clear();
        System.out.println(myStack.size());
        System.out.println("--------------------------------");

        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(1, "one");
        myHashMap.put(2, "two");
        myHashMap.put(3, "three");
        myHashMap.put(2, "four");

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(2));
        myHashMap.remove(1);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(3));

    }

}
