// Problem: Reverse every word in a string
// URL: https://takeuforward.org/plus/dsa/problems/reverse-every-word-in-a-string?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-29

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0)
                break;

            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(s.substring(i + 1, end + 1));
        }

        return result.toString();
    }
}

// Brute force approach
// Split the string into words, reverse each word and join them back together
// can use a stack to reverse position of each word
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// with string builder add the words in reverse order,
// while iterating through the string from the end to the beginning,
// as we are building the result , we do not use any extra space here
// Time complexity O(n) and space complexity O(1)