// Problem: Single Number
// URL: https://leetcode.com/problems/single-number
// Difficulty: Easy
// Date Solved: 2026-03-24

class Solution {
    public int singleNumber(int[] nums) {
        // logical XOR ^ works like it gives out 0 for taking same elements.
        // just like a^a=0
        // then (0 ^ singe) element gives out that single element as answer.
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}