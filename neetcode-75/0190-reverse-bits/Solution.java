// Problem: Reverse Bits
// URL: https://leetcode.com/problems/reverse-bits/description/
// Difficulty: Easy
// Date Solved: 2026-05-30

class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {

            ans = ans << 1 | (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}
