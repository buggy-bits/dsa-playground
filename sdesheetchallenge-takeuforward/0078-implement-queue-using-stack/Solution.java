// Problem: Implement Queue using Stack
// URL: https://takeuforward.org/plus/dsa/problems/implement-queue-using-stack?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-24

class StackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        moveIfNeeded();
        return s2.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        moveIfNeeded();
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void moveIfNeeded() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}

// Approach
// implement a queue using two stacks, s1 and s2.
// For the push operation, simply push the element onto stack s1.
// For the pop and peek operations, if s2 is empty, move all elements from s1 to
// s2 by popping then pop or peek from s2.

// Time complexity for push is O(1), and for pop and peek is amortized O(1) as
// each element is moved at most once from s1 to s2. The space complexity is
// O(n) for storing the elements in the two stacks.