// Problem: Kadanes Algorithm
// URL: https://takeuforward.org/plus/dsa/problems/kadane's-algorithm?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-02

// Kadane's algorithm - Calculate the maximum sum of a contiguous subarray
// Time complexity: O(n)  and Const space complexity: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = currSum;
        // iterate through all the elements except first as we used it earlier
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}

// Brute force approach
// Treverse all the subarrays and calculate the sum of each one
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Kadane's algorithm