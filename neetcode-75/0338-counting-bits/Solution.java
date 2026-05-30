// Problem: Counting Bits
// URL: https://leetcode.com/problems/counting-bits/description/
// Difficulty: Easy
// Date Solved: 2026-05-30

class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}