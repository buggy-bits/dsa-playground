// Problem: Z function
// URL: https://takeuforward.org/plus/dsa/problems/z-function
// Difficulty: Hard
// Date Solved: 2026-07-01

class Solution {
    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        if (pattern.length() == 0)
            return result;

        String combined = pattern + "$" + text;
        int n = combined.length();
        int m = pattern.length();

        int[] z = new int[n];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n &&
                    combined.charAt(z[i]) == combined.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }

            // pattern match found in text
            if (z[i] == m) {
                int startIndex = i - m - 1;
                result.add(startIndex);
            }
        }

        return result;
    }
}

// brute force approach
// Check for each index in the text if the pattern matches
// Time complexity O(n*m) and space complexity O(1)

// optimal approach
// Use Z function to find the pattern in the text
// start by concatenating the pattern, a special character
// and the text, then calculate the Z array for the combined string
// for each index in the Z array, if the value is equal to the length of the
// pattern, then the pattern is found in the text at that index
// Time complexity O(n+m) and space complexity O(n+m)