// Problem: Next Greater Element
// URL: https://takeuforward.org/plus/dsa/problems/next-greater-element?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-25

import java.util.*;

class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return ans;
    }
}

// Brute force approach
// For each element, traverse the array to the right and find the first greater
// element, if found, add it to the result array, else add -1
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to keep track of the elements, traverse the array from right to
// left, for each element, pop the elements from the stack that are less than or
// equal to the current element, if the stack is empty, add -1 to the result
// array, else add the top element of the stack to the result array, push the
// current element to the stack

// Time complexity O(n) and space complexity O(n)