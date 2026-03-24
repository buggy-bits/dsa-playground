// Problem: Counting Bits
// URL: https://leetcode.com/problems/counting-bits
// Difficulty: Easy
// Date Solved: 2026-03-24

class Solution {
    public int[] countBits(int n) {
        // this has a little similarity with dynamic programming.
        // use result of previous calculated number for future calculations.
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // right shift is same as dividing by 2
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}