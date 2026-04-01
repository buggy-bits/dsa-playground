// Problem: Longest Subarray of 1's After Deleting One Element
// URL: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
// Difficulty: Medium
// Date Solved: 2026-04-01

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int max_length = 0;
        int last_zero = -1;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = last_zero + 1;
                last_zero = right;
            }
            max_length = Math.max(max_length, right - left);
        }
        return max_length;
    }
}
