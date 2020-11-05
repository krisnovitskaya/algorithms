package ru.krisnovitskaya.stackandqueue.stack;

import java.util.Arrays;

public class StackGrow<E> extends StackImpl<E> {
    public StackGrow(int maxSize) {
        super(maxSize);
    }

    private void checkFullAndGrow(){
        if(size() == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    @Override
    public void push(E value) {
        checkFullAndGrow();
        super.push(value);
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
