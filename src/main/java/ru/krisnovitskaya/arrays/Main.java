package ru.krisnovitskaya.arrays;


import java.util.Random;
import java.util.function.Consumer;


public class Main {
//    1. Создать массив большого размера (миллион элементов).
//    2. Написать методы удаления, добавления, поиска элемента массива.
//    3. Заполнить массив случайными числами.
//    4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.

    final static int ARR_LENGTH = 100000;
    public static void main(String[] args) {

        Array<Integer> myArrayB = new ArrayImpl<>(ARR_LENGTH);
        Array<Integer> myArrayS = new ArrayImpl<>(ARR_LENGTH);
        Array<Integer> myArrayI = new ArrayImpl<>(ARR_LENGTH);

        fillArraysSameValues(100, myArrayB, myArrayS, myArrayI);

        System.out.printf("Time sort Bubble: %d%n",doSort(myArrayB, Array::sortBubble));
        System.out.printf("Time sort Select: %d%n",doSort(myArrayS, Array::sortSelect));
        System.out.printf("Time sort Insert: %d%n",doSort(myArrayI, Array::sortInsert));

    }


    private static long doSort(Array customArray, Consumer<Array> sort){
        long sortStart = System.currentTimeMillis();
        sort.accept(customArray);
        return System.currentTimeMillis() - sortStart;
    }

    @SafeVarargs
    private static void fillArraysSameValues(int maxValue, Array<Integer> ...arrays){
        Random random = new Random();
        for(int i = 0; i < ARR_LENGTH; i++){
            Integer next = random.nextInt(maxValue);


            for (Array<Integer> array : arrays) {
                array.add(next);
            }
        }
    }
}
