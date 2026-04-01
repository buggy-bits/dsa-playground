// Problem: Max Number of K-Sum Pairs
// URL: https://leetcode.com/problems/max-number-of-k-sum-pairs/
// Difficulty: Medium
// Date Solved: 2026-04-01

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        // Remove all numbers that are greater than or equal to k.
        // This step alone made the execution time fast.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k)
                nums[i] = 0;
        }
        // To use two pointer, this array has to be sorted. or can use hashmap approach.
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == k) {
                // its a valid pair
                ans++;
                i++;
                j--;
            } else if (sum > k) {
                // Too big
                j--;
            } else {
                // Too small
                i++;
            }
        }
        return ans;

    }
}