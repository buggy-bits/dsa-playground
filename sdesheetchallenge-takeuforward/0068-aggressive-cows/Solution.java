// Problem: Aggressive Cows
// URL: https://takeuforward.org/plus/dsa/problems/aggressive-cows?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-21

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        int n = nums.length;

        // Sort stall positions
        java.util.Arrays.sort(nums);

        // Binary search range: [1, max_distance]
        int low = 1;
        int high = nums[n - 1] - nums[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, n, mid, k)) {
                result = mid; // this distance is possible, try larger
                low = mid + 1;
            } else {
                high = mid - 1; // not possible, try smaller
            }
        }

        return result;
    }

    // Check if we can place k cows with at least 'minDist' between them
    private boolean isPossible(int[] nums, int n, int minDist, int k) {
        int cowsPlaced = 1; // place first cow at first stall
        int lastPosition = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] - lastPosition >= minDist) {
                cowsPlaced++;
                lastPosition = nums[i];

                if (cowsPlaced == k) {
                    return true;
                }
            }
        }

        return false;
    }
}

// Brute force approach
// Use 2 nested loops to check all possible distances between cows and find the
// maximum distance that allows placing k cows
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use binary search to find the maximum minimum distance between cows
// Sort the stall positions and use binary search on the distance range
// Check if it's possible to place k cows with at least 'mid' distance btw them
// If possible, try for a larger distance, otherwise try for a smaller distance
// Time complexity O(n log n) and space complexity O(1)