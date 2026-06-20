// Problem: Matrix Median
// URL: https://takeuforward.org/plus/dsa/problems/matrix-median?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-20

class Solution {
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][m - 1]);
        }

        int desired = (n * m + 1) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;

            int place = 0;
            for (int i = 0; i < n; i++) {
                place += upperBound(matrix[i], mid);
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }

        return min;
    }

    private int upperBound(int[] row, int target) {
        int low = 0, high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (row[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}

// Brute force approach
// Use a list to store all the elements of the matrix and sort it
// Time complexity O(n * m log (n * m)) and space complexity O(n * m)

// Optimal approach
// Use binary search to find the median
// The median is the (n * m + 1) / 2 th smallest element in the matrix
// We can find the count of elements less than or equal to mid using upper bound
//
// Time complexity O(32 * n * log m) and space complexity O(1)