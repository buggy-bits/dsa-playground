// Problem: Remove duplicates from sorted array
// URL: https://takeuforward.org/plus/dsa/problems/remove-duplicates-from-sorted-array?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-14

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int uniqueCount = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}

// brute force approach
// Create a new array and copy the unique elements in the new array, return the
// length of the new array
// Time complexity O(n) and space complexity O(n)

// optimal approach
// Use two pointers, one pointer to traverse the array and the other pointer to
// keep track of the unique elements, return the length of the unique elements
// Time complexity O(n) and space complexity O(1)