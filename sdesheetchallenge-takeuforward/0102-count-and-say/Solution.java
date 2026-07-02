// Problem: Count and say
// URL: https://takeuforward.org/plus/dsa/problems/count-and-say?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-02

class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }

        return result;
    }
}

// Brute force approach
// Use a loop to generate the sequence from 1 to n, and for each number, count
// the
// occurrences of each digit and construct the next number in the sequence
// Time complexity O(n * m) where m is the length of the string at each step and
// space complexity O(m) where m is the length of the string at each step

// Optimal approach
// Use a loop to generate the sequence from 1 to n, and for each number, count
// the
// occurrences of each digit and construct the next number in the sequence using
// a
// StringBuilder to avoid creating new strings at each step
// Time complexity O(n * m) where m is the length of the string at each step