// Problem: Minimum number of platforms required for a railway
// URL: https://takeuforward.org/plus/dsa/problems/minimum-number-of-platforms-required-for-a-railway?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-15

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int platforms = 1;
        int maxPlatforms = 1;

        int i = 1; // arrival pointer
        int j = 0; // departure pointer

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}

// Brute force approach
// Use a nested loop to check for each train if it overlaps with any other train
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Sort the arrival and departure times
// Use two pointers to iterate through arrival and departure times
// If arrival time is less than or equal to departure time, increment platforms
// update the maximum number of platforms
// If arrival time is greater than departure time, decrement platforms

// Time complexity O(n log n) and space complexity O(1)