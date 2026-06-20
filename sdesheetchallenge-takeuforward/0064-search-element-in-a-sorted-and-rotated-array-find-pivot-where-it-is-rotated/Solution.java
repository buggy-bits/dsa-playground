// Problem: Search element in a sorted and rotated array/ find pivot where it is rotated
// URL: https://takeuforward.org/plus/dsa/problems/search-in-rotated-sorted-array-i?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-20

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((mid & 1) == 1) { // odd
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else { // even
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    right = mid;
                }
            }
        }

        return nums[left];
    }
}

// @formatter:off
// Brute force approach
// Iterate through the array and check if the current element is equal to the next element
// Time complexity O(n) and space complexity O(1)

// Optimal approach
// Use binary search to find the single element in the sorted array
// The single element will be the one that is not equal to its adjacent elements
// If the mid index is odd and the element at mid is equal to the element at mid- 1, 
// then the single element must be in the right half of the array, otherwise it is in the left half
// If the mid index is even and the element at mid is equal to the element at mid + 1, 
// then the single element must be in the right half of the array, otherwise it is in the left half
// The loop continues until left is equal to right, at which point left will be pointing to single element
// Time complexity O(log n) and space complexity O(1)