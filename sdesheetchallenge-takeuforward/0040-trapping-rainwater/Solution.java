// Problem: Trapping Rainwater
// URL: https://takeuforward.org/plus/dsa/problems/trapping-rainwater?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-14

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}

// Brute force approach
// For each element, find the maximum height to the left and right of it,
// the water trapped at that element is the minimum of the two maximum heights
// minus the height of the element itself, sum up the water trapped at each
// element to get the total water trapped
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use two arrays to store the maximum height to the left and right of each
// element, the water trapped at that element is the minimum of the two maximum
// heights minus the height of the element itself, sum up the water trapped at
// each element to get the total water trapped
// Time complexity O(n) and space complexity O(n)
