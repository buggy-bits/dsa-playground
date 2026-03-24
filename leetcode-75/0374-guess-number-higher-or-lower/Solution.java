// Problem: Guess Number Higher or Lower
// URL: https://leetcode.com/problems/guess-number-higher-or-lower
// Difficulty: Easy
// Date Solved: 2026-03-24

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int high = n, low = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guess = guess(mid);
            if (guess == -1) {
                high = mid - 1;
            } else if (guess == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}