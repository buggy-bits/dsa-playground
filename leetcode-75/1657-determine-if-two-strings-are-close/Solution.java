// Problem: Determine if Two Strings Are Close
// URL: https://leetcode.com/problems/determine-if-two-strings-are-close/
// Difficulty: Medium
// Date Solved: 2026-03-25

class Solution {
    public boolean closeStrings(String word1, String word2) {

        int cSize1 = word1.length();
        int cSize2 = word2.length();

        if (cSize1 != cSize2)
            return false;

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (char c : word1.toCharArray()) {
            f1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            f2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(f1);
        Arrays.sort(f2);

        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}