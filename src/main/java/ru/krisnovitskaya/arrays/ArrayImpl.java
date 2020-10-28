package ru.krisnovitskaya.arrays;

import java.util.Arrays;
import java.util.Objects;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 8;
    private E[] data;
    private int size;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size > 0 ? size * 2 : 1 ;
    }

    @Override
    public void insert(E value, int index) {

        if (index == size) {
            add(value);
        } else {
            checkIndex(index);
            checkAndGrow();
            if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index + 1 + 1, size - 1 - index);
            data[index] = value;
            size++;
        }


    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyCustomArrayIndexOutOfBoundException(index, size);
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && (remove(index) != null);

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null;
        size--;
        return removedValue;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(value)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public Array<E> sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - j; j++) {
                  if(data[j].compareTo(data[j + 1]) > 0){
                        swap(j, j + 1);
                  }
            }
        }
        return this;
    }

    @Override
    public Array<E> sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minNdx = i;
            for (int j = i + 1; j < size; j++) {
                if(data[j].compareTo(data[minNdx]) < 0){
                    minNdx = j;
                }
            }
            swap(minNdx, i);
        }
        return this;
    }

    @Override
    public Array<E> sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int insert = i;
            while(insert > 0 && data[insert - 1].compareTo(temp) > 0){
                data[insert] = data[insert - 1];
                insert--;
            }
            data[insert] = temp;
        }
        return this;
    }

    private void swap(int ndxA, int ndxB) {
        E temp = data[ndxA];
        data[ndxA] = data[ndxB];
        data[ndxB] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if(size > 0){
            sb.append(data[size-1]);
        }
        sb.append("]");
        return sb.toString();
    }
}
