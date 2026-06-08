// Problem: Longest Substring Without Repeating Characters
// URL: https://takeuforward.org/plus/dsa/problems/longest-substring-without-repeating-characters?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-08

import java.util.HashSet;

class Solution {
    public int longestNonRepeatingSubstring(String s) {
        int a, b;
        a = 0;
        b = 0;
        int n = s.length();
        HashSet<Character> mySet = new HashSet<>();
        int maxSubstringLength = 0;
        while (b < n) {
            char myChar = s.charAt(b);
            if (!mySet.contains(myChar)) {
                mySet.add(myChar);
                maxSubstringLength = Math.max(maxSubstringLength, b - a + 1);
                b++;
            } else {

                mySet.remove(s.charAt(a));
                a++;

            }
        }
        return maxSubstringLength;
    }
}

// Brute force approach
// Iterate through all possible substrings
// check if they have repeating characters
// update the length of longest
// Time complexity O(n^3) and space complexity O(n)

// Optimal approach
// Use two pointers to create a sliding window,
// a HashSet to store and check for repeating characters in the current window,
// keep on increasing the window to right ,update the length of longest
// if a character is found repeating,
// start removing chars from left till this repeating char is removed.
// after removing, continue the window
// Time complexity O(n) and space complexity O(n)

// More optimal approach
// Instead of using a HashSet, we can use an array of size 256 to store the last
// index of each character,
// Time complexity O(n) and space complexity O(1)