// Problem: KMP Algorithm or LPS array
// URL: https://takeuforward.org/plus/dsa/problems/kmp-algorithm-or-lps-array?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-01

class Solution {
    public List<Integer> search(String pat, String txt) {
        List<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        if (m == 0 || n < m)
            return result;

        int[] lps = buildLPS(pat);

        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j); // match found
                j = lps[j - 1]; // continue searching
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

// Approach
// we use KMP algorithm to find all occurrences of the pattern in the text
// Build the LPS (Longest Prefix Suffix) array for the pattern
// Use the LPS array to skip characters in the pattern when a mismatch occurs
// Time complexity O(n + m) and space complexity O(m)
