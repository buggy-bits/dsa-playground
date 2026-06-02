// Problem: Sort an array of 0's 1's and 2's
// URL: https://takeuforward.org/plus/dsa/problems/sort-an-array-of-0's-1's-and-2's?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-02

class Solution {
    public void sortZeroOneTwo(int[] nums) {
        int n = nums.length;

        int left = 0;
        int mid = 0;
        int right = n - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                // replace with low and increase low
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;

                mid++;
                left++;
            } else if (nums[mid] == 2) {
                // replace with high and decrease high
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;

                right--;
            } else {
                // then its 1 so increase mid
                mid++;
            }

        }
    }
}

// For Brute force approach
// Sort the array using any algo or use Arrays.sort()
// Time complexity O(n log n) and space complexity O(1) mostly

// A better approach is to use counting sort,
// Use a hashmap, count the occurances
// fill the same array with the count of 0's, then 1's and then 2's

// Optimal approach is to use 3 pointers, low, mid and high
// It is also called as Dutch National Flag algorithm
// left points to the position to put next 0
// mid moves through the array
// right points to the position to put next 2 (moves from right to left)
// Check the value at mid, replace it with either left or right pointer
// elements.
// Therefore Time complexity will be O(n) and const space complexity O(1)