// Problem: Sliding Window Maximum
// URL: https://takeuforward.org/plus/dsa/problems/largest-rectangle-in-a-histogram?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-27

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0)
            return new int[0];

        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store the maximum for the current window
            if (i >= k - 1) {
                ans[i - k + 1] = arr[dq.peekFirst()];
            }
        }

        return ans;
    }
}

// @formatter:off

// Approach
// Use a deque to keep track of the indices of the elements in the current window
// For each element, remove indices that are out of the current window and remove
// smaller elements from the back of the deque
// The front of the deque will always have the index of the maximum element for the current window
// Time complexity O(n) and space complexity O(k)
