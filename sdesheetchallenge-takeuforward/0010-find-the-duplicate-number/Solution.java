// Problem: Find the Duplicate Number
// URL: https://takeuforward.org/plus/dsa/problems/find-the-duplicate-number?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-04

class Solution {
    public int findDuplicate(int[] nums) {

        int n = nums.length - 1;
        int xor = nums[0];

        for (int i = 1; i <= n; i++) {
            xor = xor ^ nums[i];
            xor = xor ^ i;
        }
        return xor;
    }
}

// Brute force
// Use a frequency array to count occurrences of each number,
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// Use XOR to find the duplicate number
// Time complexity O(n) and space complexity O(1)

// Another approach is to use the array itself to mark visited numbers
// Time complexity O(n) and space complexity O(1)
// The problem says no to modify the array, this will not help.