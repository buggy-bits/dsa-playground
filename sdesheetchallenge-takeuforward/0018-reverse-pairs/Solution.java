// Problem: Reverse Pairs
// URL: https://takeuforward.org/plus/dsa/problems/reverse-pairs?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-06

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j])
                    cnt++;
            }
        }
        return cnt;

    }
}

// Brute force approach
// Use a nested loop to check for each pair of elements if they satisfy the
// condition
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use merge sort to count the reverse pairs while merging the two halves
// Time complexity O(n log n) and space complexity O(n)
