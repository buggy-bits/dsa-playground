// Problem: Pascal's Triangle 1
// URL: https://takeuforward.org/plus/dsa/problems/pascals-triangle-i?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-01

// Using Mathematical approach

class Solution {
    public int pascalTriangleI(int r, int c) {
        return (int) nCr(r - 1, c - 1);
    }

    private long nCr(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }
        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}

// @formatter:off

/*  ecursive approach

class Solution {
    public int pascalTriangleI(int r, int c) {
        return recursiveFunc(r, c);
    }
    
    private int recursiveFunc(int r, int c) {
        if (c == 1 || r == c) {
            return 1;
        }
        return recursiveFunc(r - 1, c - 1) + recursiveFunc(r - 1, c);
    }
}
*/

// Resursive can be easy implementation but this will be of exponential time
// complexity O(2^n)
// will not work for large values and space complexity O(n) for recursive stack

// Can use memoization for optimisation, create a 2D array and store the values
// so we do not have to calculate the same value again and again,
// Time complexity will be O(n^2) and space complexity will also be O(n^2)

// End the end mathematical approach is the best
// Use nCr = n! / (r! * (n - r)!) and calculate the value using a loop,
// Time complexity will be O(r) and constant O(1) space complexity.