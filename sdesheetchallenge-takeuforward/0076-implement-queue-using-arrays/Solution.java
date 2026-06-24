// Problem: Implement Queue using Arrays
// URL: https://takeuforward.org/plus/dsa/problems/implement-queue-using-arrays?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-24

class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        arr = new int[1000]; // capacity
        front = 0;
        rear = 0;
        size = 0;
    }

    public void push(int x) {
        if (size == arr.length) {
            throw new RuntimeException("Queue is full");
        }

        arr[rear] = x;
        rear = (rear + 1) % arr.length;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int val = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

// @formatter:off
// Approach
// Implement a queue using an array. Use two pointers, front and rear, to keep
// track of the front and rear of the queue. The push operation adds an element
// at the rear and updates the rear pointer. The pop operation removes an element
// from the front and updates the front pointer. The peek operation returns the
// front element without removing it. The isEmpty operation checks if the queue
// is empty.

// Time complexity for push, pop, peek, and isEmpty operations is O(1). The space
// complexity is O(n) for storing the elements in the array.