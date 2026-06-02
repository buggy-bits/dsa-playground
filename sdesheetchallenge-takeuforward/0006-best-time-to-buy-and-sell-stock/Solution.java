// Problem: Best time to buy and sell stock
// URL: https://takeuforward.org/plus/dsa/problems/best-time-to-buy-and-sell-stock?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-02

class Solution {
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        int minPrice = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            }

            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }
}

// Brute force approach
// Look at all the pairs and calculate the profit, return maximum profit
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Keep track of the minimum price and maximum profit at each step, return the
// maximum profit at the end
// Time complexity O(n) and space complexity O(1)

// Another approach is to use 2 pointers, one at the start and one at the end,
// calculate the profit and move the pointers accordingly
// Time complexity O(n) and space complexity O(1)