// Problem: Permutation Sequence
// URL: https://takeuforward.org/plus/dsa/problems/permutation-sequence?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-17

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);

        k = k - 1;

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(numbers.get(k / fact));
            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return sb.toString();
    }
}

// @formatter:off
// Brute force approach
// Generate all permutations of the numbers from 1 to n and return the k-th permutation
// Time complexity O(n!) and space complexity O(n!)

// Optimal approach
// Use the factorial number system to find the k-th permutation directly without generating all permutations
// 1. Calculate the factorial of (n-1) to determine the number of permutations for each digit.
// 2. Create a list of numbers from 1 to n.
// 3. Adjust k to be zero-based by subtracting 1 from it.
// 4. While there are still numbers left in the list:
//    a. Determine the index of the current digit by dividing k by the factorial.
//    b. Append the number at that index to the result and remove it from the list
//    c. Update k to be the remainder of k divided by the factorial.
//    d. Update the factorial to be the factorial of the remaining numbers.
// Time complexity O(n^2) and space complexity O(n)
