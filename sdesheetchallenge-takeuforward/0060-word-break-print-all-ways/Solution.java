// Problem: Word Break (print all ways)
// URL: https://takeuforward.org/plus/dsa/problems/word-break?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-19

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

// @formatter:off
// Brute force approach
// Generate all possible partitions of the string and check if each partition is in the dictionary
// Time complexity O(2^n) and space complexity O(n)


// Optimal approach
// Use dynamic programming to check if the string can be segmented into words from the dictionary
// Time complexity O(n^2) and space complexity O(n)