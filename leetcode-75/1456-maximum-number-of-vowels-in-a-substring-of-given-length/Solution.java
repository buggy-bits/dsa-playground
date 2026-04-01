// Problem: Maximum Number of Vowels in a Substring of Given Length
// URL: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
// Difficulty: Medium
// Date Solved: 2026-04-01

class Solution {
    // as we have fixed chars to check for vowel, better to use logical, and not
    // HashSet for lookup
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        // Constant size sliding window
        int maxVowel = 0;
        int l = 0;
        int n = s.length();
        int count = 0;

        for (int r = 0; r < n; r++) {
            if (isVowel(s.charAt(r))) {
                count++;
            }
            if ((r - l + 1) == k) {
                maxVowel = Math.max(maxVowel, count);
                if (isVowel(s.charAt(l))) {
                    count--;
                }
                l++;
            }
        }
        return maxVowel;

    }
}
