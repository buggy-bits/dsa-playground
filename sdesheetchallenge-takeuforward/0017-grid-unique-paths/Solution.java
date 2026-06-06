// Problem: Grid unique paths
// URL: https://takeuforward.org/plus/dsa/problems/grid-unique-paths?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-06

class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        int[] copyRow = new int[n];
        for (Integer x : copyRow) {
            x = 1;
        }
        row[0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] = copyRow[j] + row[j - 1];
            }
            copyRow = row;
        }
        return row[n - 1];
    }
}

// Brute force approach
// Use a recursive function to count the number of paths from the top left
// corner to the bottom right corner
// Time complexity O(2^(m+n)) and space complexity O(m+n)

// Optimal approach
// Use dynamic programming to store the number of paths to reach each cell
// create a 2D array, where dp[i][j] represents the number of paths to reach

// The number of paths to (i,j) is (i-1,j) + cell (i,j-1)
// Time complexity O(m*n) and space complexity O(m*n)

// More optimal approach - space optimised
// We only need the previous row to calculate the current row,
// so Use two 1D arrays to store the number of paths in the
// current row and the previous row
// Time complexity O(m*n) and space complexity O(n)