// Problem: Search in a 2D matrix
// URL: https://takeuforward.org/plus/dsa/problems/search-in-a-2d-matrix?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-05

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int a = 0;
        int b = n * m - 1;

        while (a <= b) {
            int mid = a + (b - a) / 2;
            if (mat[mid / m][mid % m] == target) {
                return true;
            } else if (mat[mid / m][mid % m] > target) {
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }
        return false;
    }

}

// Brute force approach
// Use a nested loop to iterate through the matrix and check for the target
// Time complexity O(n*m) and space complexity O(1)

// Optimal approach
// Use binary search on the matrix, treating it as a sorted array

// Time complexity O(log(n*m)) and space complexity O(1)