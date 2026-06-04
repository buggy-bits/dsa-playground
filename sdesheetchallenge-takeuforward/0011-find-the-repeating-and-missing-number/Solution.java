// Problem: Find the repeating and missing number
// URL: https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-04

class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;

        long sum = 0;
        long sumSq = 0;

        // Calculate actual sum and sum of squares from the array
        for (int num : nums) {
            sum += num;
            sumSq += (long) num * num;
        }

        // Expected sum and sum of squares for numbers from 1 to n
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumSq = (long) n * (n + 1) * (2 * n + 1) / 6;

        // Difference gives (A - B) where A is repeating and B is missing
        long diff = sum - expectedSum;

        // Difference of squares gives (A^2 - B^2)
        long sqDiff = sumSq - expectedSumSq;

        // From identity: A^2 - B^2 = (A - B)(A + B)
        long sumAB = sqDiff / diff; // This gives (A + B)

        // Solve equations:
        // A - B = diff
        // A + B = sumAB
        long A = (diff + sumAB) / 2;
        long B = A - diff;

        return new int[] { (int) A, (int) B };
    }
}

// Brute force approach
// Use a frequency array to count occurrences of each number,
// use it to find the repeating and missing numbers

// Optimal approach
// Mathematical approach using sum and sum of squares
// It comes from the famous equation (a+b)(a-b) = a^2 - b^2
// Time complexity O(n) and space complexity O(1)