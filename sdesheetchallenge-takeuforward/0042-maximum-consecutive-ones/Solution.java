// Problem: Maximum Consecutive Ones
// URL: https://takeuforward.org/plus/dsa/problems/maximum-consecutive-ones?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-14

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int currentCount = 0;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

                currentCount = 0;
            } else {

                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }
}

// approach
// Traverse the array and count the number of consecutive 1's
// Time complexity O(n) and space complexity O(1)
