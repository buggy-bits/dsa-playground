// Problem: Domino and Tromino Tiling
// URL: https://leetcode.com/problems/domino-and-tromino-tiling/
// Difficulty: Medium
// Date Solved: 2026-05-04

class Solution {
    public int numTilings(int N) {
        int md = 1000000007;
        long[] v = new long[1001];

        v[1] = 1;
        v[2] = 2;
        v[3] = 5;

        if (N <= 3)
            return (int) v[N];

        for (int i = 4; i <= N; ++i) {
            v[i] = (2 * v[i - 1] + v[i - 3]) % md;
        }

        return (int) v[N];
    }
}

/*
 * Formula: v[n] = 2 * v[n - 1] + v[n - 3]
 * Special cases for n 1,2,3
 * here i used long array as we deal with large numbers and we need to take mod
 * at each step to avoid overflow, so long felt a better approach than int
 * array.
 * 
 */