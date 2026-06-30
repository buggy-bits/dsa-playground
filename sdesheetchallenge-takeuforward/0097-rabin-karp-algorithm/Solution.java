// Problem: Rabin Karp Algorithm
// URL: https://takeuforward.org/plus/dsa/problems/rabin-karp-algorithm?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-30

import java.util.*;

class Solution {
    public List<Integer> search(String pat, String txt) {
        List<Integer> result = new ArrayList<>();

        int m = pat.length();
        int n = txt.length();

        if (m > n)
            return result;

        long mod = 1000000007;
        long base = 256;

        long patHash = 0;
        long txtHash = 0;
        long power = 1; // base^(m-1)

        // compute base^(m-1)
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        // initial hash
        for (int i = 0; i < m; i++) {
            patHash = (patHash * base + pat.charAt(i)) % mod;
            txtHash = (txtHash * base + txt.charAt(i)) % mod;
        }

        // slide window
        for (int i = 0; i <= n - m; i++) {

            // check hash match
            if (patHash == txtHash) {
                // verify to avoid collision
                if (txt.substring(i, i + m).equals(pat)) {
                    result.add(i);
                }
            }

            // update rolling hash
            if (i < n - m) {
                txtHash = (txtHash - txt.charAt(i) * power % mod + mod) % mod;
                txtHash = (txtHash * base + txt.charAt(i + m)) % mod;
            }
        }

        return result;
    }
}

// Approach
// rabin karp algorithm uses rolling hash to find the pattern in the text
// calculate the hash of the pattern and the first window of the text
// then slide the window and update the hash of the text
// if the hash of the pattern and the text match, then check for the actual
// string to avoid collision
// Time complexity O(n + m) and space complexity O(1)
