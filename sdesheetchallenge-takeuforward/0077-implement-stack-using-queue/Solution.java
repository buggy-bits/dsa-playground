// Problem: Implement Stack using Queue
// URL: https://takeuforward.org/plus/dsa/problems/implement-stack-using-queue?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-24

class QueueStack {
    Queue<Integer> q;

    public QueueStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}

// Approach
// Implement a stack using a single queue.
// For the push, add the element to the queue and then rotate the queue
// For the pop, remove the front element from the queue.
// For top operation, return the front element of the queue without removing it.
// The isEmpty operation checks if the queue is empty.

// Time complexity for push is O(n) due to the rotation, while pop, top, and
// isEmpty operations are O(1). The space complexity is O(n) for storing the