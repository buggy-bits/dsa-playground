// Problem: N-th Tribonacci Number
// URL: https://leetcode.com/problems/n-th-tribonacci-number/
// Difficulty: Easy
// Date Solved: 2026-04-15

class Solution {

    public int tribonacci(int n) {
        if (n <= 2) {
            return n > 0 ? 1 : 0;
        }

        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 1;
        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
        }

        return ans[n];
    }
}

// This is a Bottom Up Tabulation approach,
// Can also be solved using Top Down Memoization approach (recursive) )