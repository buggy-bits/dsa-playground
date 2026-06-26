// Problem: LFU Cache
// URL: https://takeuforward.org/plus/dsa/problems/lfu-cache?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-26

import java.util.*;

class LFUCache {

    class Node {
        int key, value, cnt;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }

    class List {
        int size;
        Node head, tail;

        List() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    Map<Integer, Node> keyNode;
    Map<Integer, List> freqListMap;
    int maxSizeCache;
    int minFreq;
    int curSize;

    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    private void updateFreqListMap(Node node) {
        keyNode.remove(node.key);

        List oldList = freqListMap.get(node.cnt);
        oldList.removeNode(node);

        if (node.cnt == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.cnt++;

        List newList = freqListMap.getOrDefault(node.cnt, new List());
        newList.addFront(node);

        freqListMap.put(node.cnt, newList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key))
            return -1;

        Node node = keyNode.get(key);
        updateFreqListMap(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0)
            return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
            return;
        }

        if (curSize == maxSizeCache) {
            List list = freqListMap.get(minFreq);
            Node nodeToRemove = list.tail.prev;
            keyNode.remove(nodeToRemove.key);
            list.removeNode(nodeToRemove);
            curSize--;
        }

        curSize++;
        minFreq = 1;

        Node node = new Node(key, value);

        List list = freqListMap.getOrDefault(minFreq, new List());
        list.addFront(node);

        freqListMap.put(minFreq, list);
        keyNode.put(key, node);
    }
}

//@formatter:off
// Approach
// 1. We will use two HashMaps and a Doubly Linked List to implement the LFU Cache.
// 2. The first HashMap (keyNode) will store the key and its corresponding Node (which contains the key, value, and frequency count).
// 3. The second HashMap (freqListMap) will store the frequency count and its corresponding List (which is a Doubly Linked List of Nodes with the same frequency).
// 4. The List class will have methods to add a Node to the front and remove a Node from the list.
// 5. The Node class will have attributes for key, value, frequency count, and pointers to the previous and next Nodes in the list.