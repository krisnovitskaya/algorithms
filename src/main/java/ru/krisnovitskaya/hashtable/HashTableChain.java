package ru.krisnovitskaya.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;


public class HashTableChain<K, V> implements HashTable<K, V> {


    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }

    private class IndexPair {
        final int dataIndex;
        final int listIndex;

        public IndexPair(int dataIndex, int listIndex) {
            this.dataIndex = dataIndex;
            this.listIndex = listIndex;
        }
    }

    private static final int START_SIZE = 5;
    private static final int GROW_POWER = 2;

    private ArrayList<Node<K, V>>[] data;
    private int size;

    public HashTableChain() {
        data = new ArrayList[START_SIZE];
    }


    private void put(Node<K, V> node) {
        put(node.getKey(), node.getValue());
    }

    @Override
    public boolean put(K key, V value) {

        if (size == data.length) {
            growTable();
        }

        IndexPair indexPair = indexOf(key);
        if (data[indexPair.dataIndex] == null) {
            data[indexPair.dataIndex] = new ArrayList<>();
            data[indexPair.dataIndex].add(new Node<>(key, value));
            size++;
        } else if (indexPair.listIndex != -1) {
            data[indexPair.dataIndex].get(indexPair.listIndex).setValue(value);
        } else {
            data[indexPair.dataIndex].add(new Node<>(key, value));
            size++;
        }
        return true;
    }

    private void growTable() {
        LinkedList<Node<K, V>> temp = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].size() != 0) {
                temp.addAll(data[i]);
            }
        }
        data = new ArrayList[data.length * GROW_POWER];
        size = 0;
        for (Node<K, V> node : temp) {
            put(node);
        }
    }

    @Override
    public V get(K key) {
        IndexPair indexes = indexOf(key);
        if (indexes.listIndex == -1) {
            return null;
        }
        return data[indexes.dataIndex].get(indexes.listIndex).getValue();
    }


    private IndexPair indexOf(K key) {
        int index = hash(key);
        IndexPair indexPair = new IndexPair(index, -1);

        if (data[index] != null) {
            for (int i = 0; i < data[index].size(); i++) {
                if (data[index].get(i).getKey().equals(key)) {
                    indexPair = new IndexPair(index, i);
                    return indexPair;
                }
            }
        }
        return indexPair;
    }

    @Override
    public V remove(K key) {
        IndexPair indexes = indexOf(key);
        if (indexes.listIndex == -1) {
            return null;
        }

        V value = data[indexes.dataIndex].get(indexes.listIndex).getValue();
        data[indexes.dataIndex].remove(indexes.listIndex);
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }
}
