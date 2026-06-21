// Problem: Kth element of 2 sorted arrays
// URL: https://takeuforward.org/plus/dsa/problems/kth-element-of-2-sorted-arrays?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-21

class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        if (m > n) {
            return kthElement(b, a, k);
        }

        int left = k;
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}

// Brute force approach
// Merge the two arrays and return the kth element
// Time complexity O(m + n) and space complexity O(m + n)

// Optimal approach
// Always binary search on the smaller array.
// Pick a cut from both arrays so total left elements become k.
// Check leftMax <= rightMin on both sides to validate the partition.
// If valid, answer is max(leftMax of both); otherwise move the cut.
// Time complexity O(log(min(m, n))) and space complexity O(1)
