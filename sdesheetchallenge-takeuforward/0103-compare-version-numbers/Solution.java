// Problem: Compare version numbers
// URL: https://takeuforward.org/plus/dsa/problems/compare-version-numbers?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-02

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }
}

// @formatter:off

// Approach
// Split the version strings by '.' and compare each corresponding part as integers
// If one version has fewer parts, treat the missing parts as 0
// Return 1 if version1 is greater, -1 if version2 is greater, and 0 if they are equal
// Time complexity O(n + m) where n and m are the lengths of the version strings
