// Problem: Valid Anagram
// URL: https://takeuforward.org/plus/dsa/problems/valid-anagram?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-02

class Solution {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

// @formatter:off
// Approach
// Use a frequency array to count the occurrences of each character in both strings
// Time complexity O(n) and space complexity O(1) since the frequency array size is