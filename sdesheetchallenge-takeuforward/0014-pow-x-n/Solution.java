// Problem: Pow(x, n)
// URL: https://takeuforward.org/plus/dsa/problems/pow(x,n)?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-05

class Solution {
    public double myPow(double x, int n) {

        long N = n;
        if (N < 0) {
            return 1 / power(x, -N);
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) {
            return 1.0000;
        }
        if (n == 1.0) {
            return x;
        }

        if (n % 2 == 0) {
            return power(x * x, n / 2);
        } else {
            return x * power(x, n - 1);
        }
    }
}

// Brute force approach
// Use a lop to iterate from 1 to n
// Multiply x by itself n times
// Handle negative n by taking reciprocal of x and making n positive
// Time complexity O(n) and space complexity O(1)

// Optimal approach
// Use recursion and divide the problem into smaller subproblems
// If n is even, x^n = (x^2)^(n/2) , this runs in O(log n) time
// If n is odd, x^n = x * x^(n-1), this runs in O(log n) time
// Handle negative n by taking reciprocal of x and making n positive
// Time complexity O(log n) and space complexity O(log n)