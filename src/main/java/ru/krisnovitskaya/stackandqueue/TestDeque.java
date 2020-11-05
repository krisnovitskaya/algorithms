package ru.krisnovitskaya.stackandqueue;

import ru.krisnovitskaya.stackandqueue.queue.*;

public class TestDeque {
    public static void main(String[] args) {
//        Deque<String> deque = new DequeImpl<String>(5);
//        testDeque(deque);

        //Queue<String> queue = new QueueImpl<>(5);
        Queue<String> queue = new PriorityQueue<>(5);
        testQueue(queue);
    }

    private static void testDeque(Deque<String> deque) {
        System.out.println("peekHead " + deque.peekHead());
        System.out.println("insertHead value a " + deque.insertHead("a"));
        System.out.println("insertHead value b " + deque.insertHead("b"));
        System.out.println("insertHead value c " + deque.insertHead("c"));
        System.out.println("insertHead value d " + deque.insertHead("d"));
        System.out.println("insertHead value e " + deque.insertHead("e"));
        System.out.println("peekTail " + deque.peekTail());
        System.out.println("peekHead " + deque.peekHead());

        System.out.println("removeTail valueRemoved " + deque.removeTail());
        System.out.println("removeHead valueRemoved " + deque.removeHead());

        while (!deque.isEmpty()) {
            System.out.println("removeHead " + deque.removeHead());
        }

        System.out.println("insertTail value 1 " + deque.insertTail("1"));
        System.out.println("insertTail value 2 " + deque.insertTail("2"));
        System.out.println("insertTail value 3 " + deque.insertTail("3"));
        System.out.println("insertTail value 4 " + deque.insertTail("4"));
        System.out.println("insertTail value 5 " + deque.insertTail("5"));
        System.out.println("insertTail value 6 " + deque.insertTail("6"));
        System.out.println("removeHead valueRemoved " + deque.removeHead());
        System.out.println("removeTail valueRemoved " + deque.removeTail());

        while (!deque.isEmpty()) {
            System.out.println("removeTail " + deque.removeTail());
        }
    }

    private static void testQueue(Queue<String> que) {
        System.out.println("peekHead " + que.peekHead());
        System.out.println("removeHead valueRemoved " + que.removeHead());

        while (!que.isEmpty()) {
            System.out.println("removeHead " + que.removeHead());
        }

        System.out.println("insertTail value 1 " + que.insertTail("1"));
        System.out.println("insertTail value 4 " + que.insertTail("4"));
        System.out.println("insertTail value 0 " + que.insertTail("0"));
        System.out.println("insertTail value 5 " + que.insertTail("5"));
        System.out.println("insertTail value 2 " + que.insertTail("2"));
        System.out.println("insertTail value 1 " + que.insertTail("1"));
        System.out.println("removeHead valueRemoved " + que.removeHead());

        while (!que.isEmpty()) {
            System.out.println("removeHead " + que.removeHead());
        }
    }
}
