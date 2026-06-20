// Problem: The N-th root of an integer
// URL: https://takeuforward.org/plus/dsa/problems/find-nth-root-of-a-number?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-20

class Solution {
    public int NthRoot(int N, int M) {
        int left = 1;
        int right = M;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = compare(mid, N, M);

            if (cmp == 0) {
                return mid; // mid^N == M
            } else if (cmp < 0) {
                left = mid + 1; // mid^N < M
            } else {
                right = mid - 1; // mid^N > M
            }
        }

        return -1;
    }

    // Returns:
    // 0 if x^N == M
    // -1 if x^N < M
    // 1 if x^N > M
    private int compare(int x, int N, int M) {
        long result = 1;

        for (int i = 0; i < N; i++) {
            result *= x;

            if (result > M) {
                return 1;
            }
        }

        if (result == M) {
            return 0;
        }

        return -1;
    }
}

// @formatter:off
// Brute force approach
// Iterate from 1 to M and check if i^N == M
// Time complexity O(M) and space complexity O(1)


// Optimal approach
// Use binary search to find the N-th root of M
// Search range from 1 to M and compare mid^N with M
// Time complexity O(log M) and space complexity O(1)
