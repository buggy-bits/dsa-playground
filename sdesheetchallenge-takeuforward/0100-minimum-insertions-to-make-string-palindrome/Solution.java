// Problem: Minimum insertions to make string palindrome
// URL: https://takeuforward.org/plus/dsa/problems/minimum-insertions-to-make-string-palindrome?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-01

class Solution {
    public int minInsertion(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lps = dp[n][n];
        return n - lps;
    }
}

// Brute force approach
// Check all possible insertions and check if the resulting string is a
// palindrome
// Time complexity O(2^n) and space complexity O(n)

// Optimal approach
// Find the longest palindromic subsequence of the string
// The minimum number of insertions required to make the string a palindrome is
// equal to the length of the string minus the length of the longest palindromic
// subsequence
// Time complexity O(n^2) and space complexity O(n^2)