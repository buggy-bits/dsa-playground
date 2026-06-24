// Problem: Implement Stack using Arrays
// URL: https://takeuforward.org/plus/dsa/problems/implement-stack-using-arrays?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-24

class ArrayStack {
    private int[] arr;
    private int top;

    public ArrayStack() {
        arr = new int[1000]; // choose capacity as needed
        top = -1;
    }

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

// @formatter:off
// Approach
// Implement a stack using an array. Use a variable `top` to keep track of the
// index of the top element in the stack. The push operation increments `top` and
// adds the new element to the array. The pop operation returns the top element
// and decrements `top`. The top operation returns the top element without
// removing it. The isEmpty operation checks if `top` is -1, indicating that the
// stack is empty.


// Time complexity for push, pop, and top operations is O(1). The space
// complexity is O(n) for storing the elements in the array.