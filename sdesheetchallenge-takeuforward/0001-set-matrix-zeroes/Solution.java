// Problem: Set Matrix Zeroes
// URL: https://takeuforward.org/plus/dsa/problems/set-matrix-zeroes?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-01

// Time complexity O(n * m) and space complexity O(1) 
// -> Question specifically wants constant space complexity
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                    ;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                    ;
                }
            }
        }

    }
}

// @formatter:off

// Brute force approach is to use 2 sets, each for Col and Row,
// look at all the elements of the matrix, if we find a 0, add the row and column index to the respective set,
// then look at the matrix again and if the row or column index is in the set,  make it 0
// Time complexity O(n * m) and space complexity O(n + m)

// Optimal approach
// Use the first row and column in place of sets, mark them with 0 when we find a 0 in the matrix
// Use a variable to check if the first column has a 0
// Process all the elemtens and later handle the first row and column separately, as they were used for marking