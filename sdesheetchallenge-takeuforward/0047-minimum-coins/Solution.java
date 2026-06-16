// Problem: Minimum coins
// URL: https://takeuforward.org/plus/dsa/problems/minimum-coins?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-16

class Solution {

    public int MinimumCoins(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];

        // initialize dp array
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;

        // build up solution
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}

// Brute force
// For each amount, we can try every coin and see if we can
// make the amount by using that coin and the remaining amount (amount - coin)
// Time complexity O(amount * number of coins) and space complexity O(amount)

// @formatter:off
// Optimal approach
// Use dynamic programming to build up the solution from the base case (amount 0)
// Create a dp array of size amount + 1, where dp[i] represents the minimum number of coins needed to make the amount i
// We can initialize the dp array with a large value (amount + 1) and set dp[0] = 0
// iterate through the dp array and for each amount, try every coin and see if we can make the amount by using that coin and the remaining amount (amount - coin) and update the dp array accordingly
// Time complexity O(amount * number of coins) and space complexity O(amount)