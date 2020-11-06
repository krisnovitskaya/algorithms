package ru.krisnovitskaya.linkedlist;

import java.util.Iterator;

public class TestSimpleLinkedList {
    public static void main(String[] args) {
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);


        System.out.println("_______test ForEach______");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

        System.out.println(linkedList.size() + " длина листа");

        System.out.println("_______test iterator______");
        Iterator<Integer> iter =  linkedList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
