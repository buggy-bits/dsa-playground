// Problem: Implement Min Stack
// URL: https://takeuforward.org/plus/dsa/problems/implement-min-stack?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-27

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// @formatter:off
// Approach
// Use two stacks: one for the main stack and another for tracking the minimum values
// When pushing a value, also push it onto the minStack if it's less than or equal to the current minimum
// When popping, if the popped value is equal to the current minimum, pop it from the minStack as well
// The top() method returns the top value of the main stack
// The getMin() method returns the top value of the minStack, which is the current minimum
// Time complexity for push, pop, top, and getMin operations is O(1)
