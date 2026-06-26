// Problem: Next Smaller Element
// URL: https://takeuforward.org/plus/dsa/problems/next-smaller-element?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-26

class Solution {
    public int[] nextSmallerElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return ans;
    }
}

// Brute force approach
// For each element in the array, iterate through the elements to the right of
// it and find the next smaller element
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to keep track of the next smaller elements,
// iterate through the array from right to left, for each element,
// pop elements from the stack until the top of the stack is smaller than the
// current element,
// if the stack is empty, there is no smaller element to the right, otherwise,
// the top of the stack is the next smaller element

// Time complexity O(n) and space complexity O(n)