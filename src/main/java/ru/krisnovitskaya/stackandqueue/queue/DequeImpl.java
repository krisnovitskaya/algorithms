package ru.krisnovitskaya.stackandqueue.queue;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {


    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertHead(E value) {
        if(isFull()) {
            return false;
        }

        if(head == 0){
            head = data.length;
        }

        data[--head] = value;
        size++;
        return true;

    }

    @Override
    public E removeTail() {
        if(isEmpty()){
            return null;
        }

        if(tail == -1){
            tail = data.length - 1;
        }

        E removedValue = data[tail--];
        size--;
        return  removedValue;
    }

    @Override
    public E peekTail() {
        if(isEmpty()) return null;
        if(tail == -1) return data[data.length - 1];
        return data[tail];
    }
}
