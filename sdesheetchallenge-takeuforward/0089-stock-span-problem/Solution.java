// Problem: Stock span problem
// URL: https://takeuforward.org/plus/dsa/problems/stock-span-problem?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-29

class Solution {
    public int[] stockSpan(int[] arr, int n) {
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);
        }

        return span;
    }
}

// Brute force approach
// For each element in the array, iterate through the elements to the left of
// it and count the number of consecutive elements that are less than or equal
// to the current element
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to keep track of the indices of the elements,
// iterate through the array from left to right, for each element,
// pop elements from the stack until the top of the stack is greater than the
// current element, if the stack is empty, the span is the current index + 1,
// otherwise the span is the difference between the current index and the index
// of the top of the stack
// Time complexity O(n) and space complexity O(n)
