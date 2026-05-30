// Problem: Number of 1 Bits
// URL: https://leetcode.com/problems/number-of-1-bits/description/
// Difficulty: Easy
// Date Solved: 2026-05-30

class Solution {
    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }
}

// class Solution {
// public int hammingWeight(int n) {
// int sum = 0;
// while (n > 0) {
// if ((n & 1) == 1) {
// sum++;
// }
// n = n >> 1;
// }
// return sum;
// }
// }