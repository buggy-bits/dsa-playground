// Problem: LRU Cache
// URL: https://takeuforward.org/plus/dsa/problems/lru-cache?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-26

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insert(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }
}

// Approach
// Use a doubly linked list to maintain the order of usage and a hashmap for
// O(1) access to nodes.
// The head of the list represents the most recently used item, while the tail
// represents the least recently used item.
// When a key is accessed or updated, move it to the head of the list. If the
// cache exceeds its capacity, remove the tail node (least recently used).
// Time complexity for get and put operations is O(1). The space complexity is
// O(capacity) for storing the nodes in the hashmap and linked list.