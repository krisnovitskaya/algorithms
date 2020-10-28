package ru.krisnovitskaya.arrays;

public class MyCustomArrayIndexOutOfBoundException extends RuntimeException {
    public MyCustomArrayIndexOutOfBoundException(int index, int size) {
        super(String.format("Invalid index %d for array with length %d", index, size));
    }
}
