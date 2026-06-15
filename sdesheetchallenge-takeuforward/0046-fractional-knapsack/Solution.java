// Problem: Fractional Knapsack
// URL: https://takeuforward.org/plus/dsa/problems/fractional-knapsack?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-15

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
        }

        // Sort by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));

        double totalValue = 0.0;
        long remainingCap = cap;

        for (int i = 0; i < n && remainingCap > 0; i++) {
            double value = items[i][0];
            double weight = items[i][1];

            if (weight <= remainingCap) {
                // take full item
                totalValue += value;
                remainingCap -= weight;
            } else {
                // take fraction
                totalValue += value * (remainingCap / weight);
                break;
            }
        }

        return totalValue;
    }
}

// Brute force approach
// Use a nested loop to iterate through the items and check for the maximum
// value/weight ratio
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Sort the items by value/weight ratio in descending order
// Iterate through the sorted items and take full items until the capacity is
// reached
// If the capacity is not reached, take a fraction of the next item
// Time complexity O(n log n) and space complexity O(n)
