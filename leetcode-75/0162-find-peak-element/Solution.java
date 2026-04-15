// Problem: Find Peak Element
// URL: https://leetcode.com/problems/find-peak-element/
// Difficulty: Medium
// Date Solved: 2026-04-15

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int mid = l + (h - l) / 2;

        while (l < h) {
            mid = l + (h - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

// with Binary search and a simple condition of checking mid and next elemtent
// we can find the peak element
// due to this check, we can even check for 2 elements,
// but the default binary search will not work as this
// This only worked because of the custom check