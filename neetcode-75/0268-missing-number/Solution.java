// Problem: Missing Number
// URL: https://leetcode.com/problems/missing-number/description/
// Difficulty: Easy
// Date Solved: 2026-05-30

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = n;
        for (int i = 0; i < n; i++) {
            x = x ^ i ^ nums[i];
        }
        return x;
    }
}
// This is bit Manipulation,
// same principle of xor operator but used different,
// (all numbers from 0 ^ 1 ^ .... n) ^ (^ between each elements)
// O(1) Extra space complexity
// O(n) Time complexity

// class Solution {
// public int missingNumber(int[] nums) {
// int n = nums.length;
// int actualSum = n*(n+1)/2;
// int sum = 0;
// for(int i =0 ; i < n; i++){
// sum+=nums[i];
// }
// return actualSum - sum;
// }
// }

// O(1) Extra space complexity
// O(n) Time complexity
