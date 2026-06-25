// Problem: Sort a Stack
// URL: https://takeuforward.org/plus/dsa/problems/sort-a-stack?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-25

class Solution {
    public void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);

        stack.push(val);
    }

    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insert(stack, temp);
        }
    }
}

// Brute force approach
// Use an auxiliary stack to sort the elements
// Time complexity O(n^2) and space complexity O(n)

// Optimal approach
// Use recursion to sort the stack in place
// run a recursive function to pop all elements from the stack
// insert back into stack while comparing each element with the top of the stack
// Time complexity O(n^2) and space complexity O(n) (due to recursion stack