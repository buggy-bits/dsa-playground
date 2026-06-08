// Problem: Largest Subarray with K sum
// URL: https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-08

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int a = 0;
        int sum = 0;
        int length = 0;

        for (int b = 0; b < n; b++) {
            sum += nums[b];

            while (sum > k && a <= b) {
                sum -= nums[a];
                a++;
            }

            if (sum == k) {
                length = Math.max(length, b - a + 1);
            }
        }
        return length;
    }
}

// Brute force approach
// Use two nested loops to find all subarrays and calculate their sum,
// if the sum is equal to k, update the length of longest subarray
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use two pointers to create a sliding window,
// increasing the window to right and calculate the sum of the current window,
// if the sum is less than k, continue, if the sum is greater than k, start
// removing elements from left till the sum is less than or equal to k, if sum
// is equal to k, update the length of longest subarray,
// continue the same till right pointer reache end of array
// Time complexity O(n) and space complexity O(1)
