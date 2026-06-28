// Problem: Maximum of Minimums for Every Window Size
// URL: https://takeuforward.org/plus/dsa/problems/maximum-of-minimums-for-every-window-size?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-29

import java.util.*;

class Solution {
    public int[] maxOfMin(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n + 1];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        Arrays.fill(ans, Integer.MIN_VALUE);

        // Find maximum of minimum for every window size
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining entries
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = ans[i];
        }

        return res;
    }
}

// Brute force approach
// For every window size, find the minimum of all windows and then find the
// maximum of those minimums
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to find the previous and next smaller elements for each element
// in the array
// The distance between the previous and next smaller elements gives the length
// of the window in which the current element is the minimum
// For each element, update maximum of minimums for corresponding window size
// Time complexity O(n) and space complexity O(n)