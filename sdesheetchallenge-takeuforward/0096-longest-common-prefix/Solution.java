// Problem: Longest Common Prefix
// URL: https://takeuforward.org/plus/dsa/problems/longest-common-prefix?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-30

class Solution {
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }

        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            while (!str[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

// Brute force approach
// iterate through each string in the array and compare it with the current
// prefix. If the current string does not start with the prefix, reduce the
// prefix by one character from the end until a common prefix is found or the
// prefix becomes empty.

// Time complexity O(n * m) where n is the number of strings and m is the length
// of the longest string.
// Space complexity O(1)