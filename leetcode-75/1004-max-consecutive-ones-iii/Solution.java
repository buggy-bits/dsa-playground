// Problem: Max Consecutive Ones III
// URL: https://leetcode.com/problems/max-consecutive-ones-iii/
// Difficulty: Medium
// Date Solved: 2026-04-01

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        int count = 0; // count number of 0's

        for (r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                count++;
            }
            if (count > k) {
                if (nums[l] == 0)
                    count--;
                l++;
            }
            // no window size constraint here
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
