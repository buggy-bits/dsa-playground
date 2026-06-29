// Problem: Longest Palindrome in a string
// URL: https://takeuforward.org/plus/dsa/problems/longest-palindromic-substring?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-29

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

// Brute force approach
// Check all substrings of the given string and check if they are palindrome or
// not
// Time complexity O(n^3) and space complexity O(1)

// Optimal approach
// Use the expand around center technique to find the longest palindrome
// For each character in the string, consider it as the center of a palindrome
// and expand outwards to check for palindromes of odd and even lengths
// Time complexity O(n^2) and space complexity O(1)