package ru.krisnovitskaya.trees;

import ru.krisnovitskaya.recursion.TestUpToThePower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestBalance {
//    1. Создать и запустить программу для построения двоичного дерева.
//    В цикле построить двадцать деревьев с глубиной в 6 уровней.
//    Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
//    Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
//    2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

    public static final int MAX_LEVEL = 4;
    public static final int LOW_BOUND = -25;
    public static final int HIGH_BOUND = 25;
    public static final int COUNT = 55;


    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            List<TreeImpl<Integer>> treesList = getTreesAndFill(COUNT, i, LOW_BOUND, HIGH_BOUND);
            System.out.printf("%d trees with maxLevel %d and bounds from %d to %d: ", COUNT, i, LOW_BOUND, HIGH_BOUND);
            printBalanceStatistic(treesList);
        }
    }

    public static List<TreeImpl<Integer>> getTreesAndFill(int count, int maxLevel, int lowBound, int highBound) {
        if (!checkParams(count, maxLevel, lowBound, highBound)) {
            throw new IllegalArgumentException("wrong params");
        }
        List<TreeImpl<Integer>> trees = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(maxLevel);
            for (int j = 0; j < TestUpToThePower.getPositivePower(2, maxLevel) - 1; j++) {
                tree.add(random.ints(lowBound, highBound + 1).findAny().getAsInt());
            }
            trees.add(tree);
        }
        return trees;
    }

    private static boolean checkParams(int count, int maxLevel, int lowBound, int highBound) {
        return count >= 0
                && maxLevel >= 0
                && lowBound <= highBound;
    }

    public static void printBalanceStatistic(List<TreeImpl<Integer>> trees) {
        if (trees.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        int countNotBalanced = 0;
        for (TreeImpl<Integer> tree : trees) {
            if (!tree.isBalanced(tree.getRoot())) {
                countNotBalanced++;
            }
        }
        System.out.printf("Not Balanced are %.3f%% trees.", (countNotBalanced * 100.0) / trees.size());
        System.out.println();
    }

}
