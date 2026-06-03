// Problem: Rotate matrix by 90 degrees
// URL: https://takeuforward.org/plus/dsa/problems/rotate-matrix-by-90-degrees?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-03

// Time complexity O(n^2) and space complexity O(1)
class Solution {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // replace the compliment locations (a,b) flip with (b,a)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // flip the matrix on vertical axis, like use reverse algo to martix columns.
        int a = 0;
        int b = n - 1;

        while (a < b) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][a];
                matrix[i][a] = matrix[i][b];
                matrix[i][b] = temp;
            }

            a++;
            b--;
        }
    }
}

// Brute force approach
// Create a new matrix, copy elements in the new matrix in the required order
// Time complexity O(n^2) and space complexity O(n^2)

// Optimal approach
// First transpose the matrix (let the posistions like (i,j) switch with (j,i)),
// Reverse the columns of the matrix, to get the required order (same as
// reversing an array, use 2 pointers)
// Time complexity O(n^2) and space complexity O(1)
