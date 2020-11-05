package ru.krisnovitskaya.stackandqueue;

import ru.krisnovitskaya.stackandqueue.stack.Stack;
import ru.krisnovitskaya.stackandqueue.stack.StackGrow;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringReverse {
    private static Stack<Character> stack = new StackGrow<>(20);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            input = reader.readLine();
            if (input.equals("exit")) break;

            addAllToStack(input);
            printAllFromStack();
        }

    }

    private static void printAllFromStack() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void addAllToStack(String input) {
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
    }
}
