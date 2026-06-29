// Problem: Roman to Integer
// URL: https://takeuforward.org/plus/dsa/problems/roman-to-integer?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-29

class Solution {
    public int romanToInt(String s) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));

            if (i + 1 < s.length()) {
                int next = value(s.charAt(i + 1));

                if (curr < next) {
                    total -= curr;
                } else {
                    total += curr;
                }
            } else {
                total += curr;
            }
        }

        return total;
    }

    private int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}

// Brute force approach
// Iterate through the string and for each character, check if the next
// character is greater than the current character. If it is, subtract the
// current character's value from the total, otherwise add it to the total.
// Time complexity O(n) and space complexity O(1)

// Optimal approach
// Use a map to store the values of the Roman numerals and iterate through the
// string. For each character, check if the next character is greater than the
// current character. If it is, subtract the current character's value from the
// total, otherwise add it to the total. This approach is more efficient as it
// avoids the switch statement and allows for faster lookups of the values.

// having a hashmap for storing values, can speed up lookups, its a fixed
// length, so constant space and time complexities

// Time complexity O(n) and space complexity O(1)