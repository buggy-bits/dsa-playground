// Problem: Implement ATOI/STRSTR
// URL: https://takeuforward.org/plus/dsa/problems/string-to-integer-atoi?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-30

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // check if empty after removing spaces
        if (i == n)
            return 0;

        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int result = 0;

        // Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}

// Approach
// Iterate through the string, skip leading spaces, check for sign, and then
// process digits until a non-digit character is found. Handle overflow by
// checking if the result exceeds Integer.MAX_VALUE or Integer.MIN_VALUE. Return
// the final result multiplied by the sign.

// Time complexity O(n) where n is the length of the string.
// Space complexity O(1)
