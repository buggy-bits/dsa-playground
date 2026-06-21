// Problem: Median of 2 sorted arrays
// URL: https://takeuforward.org/plus/dsa/problems/median-of-2-sorted-arrays?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-21

class Solution {
    public double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        if (n1 > n2) {
            return median(arr2, arr1);

        }

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = arr1[mid1];
            if (mid2 < n2)
                r2 = arr2[mid2];
            if (mid1 - 1 >= 0)
                l1 = arr1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = arr2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {

                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {

                high = mid1 - 1;
            } else {

                low = mid1 + 1;
            }
        }
        return 0;
    }
}

// Brute force approach
// Merge the two arrays and return the median
// Time complexity O(m + n) and space complexity O(m + n)

// Optimal approach
// Always binary search on the smaller array.
// Pick a cut from both arrays so total left elements become k.
// Check leftMax <= rightMin on both sides to validate the partition.
// If valid, answer is max(leftMax of both); otherwise move the cut.
// Time complexity O(log(min(m, n))) and space complexity O(1)