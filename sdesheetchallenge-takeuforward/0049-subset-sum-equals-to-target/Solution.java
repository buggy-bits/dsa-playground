// Problem: Subset sum equals to target
// URL: https://takeuforward.org/plus/dsa/problems/subset-sum-equals-to-target?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-16

class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // build up solution
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}

// Brute force approach
// Use a recursive approach to check for each element if can include it in
// the subset or not and check if we can make the target sum
// Time complexity O(2^n) and space complexity O(n)

// Optimal approach
// Use dynamic programming to build up the solution from the base case (target
// 0)
// Create a dp array of size (n + 1) x (target + 1), where dp[i][j] represents
// whether we can make the target j using the first i elements of array
// initialize the dp array with false and set dp[i][0] = true for all i
// because we can make the target 0 by not including any element
// iterate through the dp array and for each element, either include it
// in the subset or not include it, and update the dp array accordingly
// Time complexity O(n * target) and space complexity O(n * target)