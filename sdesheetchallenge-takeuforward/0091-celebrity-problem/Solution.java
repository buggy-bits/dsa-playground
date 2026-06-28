// Problem: Celebrity Problem
// URL: https://takeuforward.org/plus/dsa/problems/celebrity-problem?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-29

class Solution {
    public int celebrity(int[][] M) {
        int n = M.length;

        int cand = 0;
        for (int i = 1; i < n; i++) {
            if (M[cand][i] == 1) {
                cand = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != cand) {
                if (M[cand][i] == 1 || M[i][cand] == 0) {
                    return -1;
                }
            }
        }

        return cand;
    }
}

// Brute force approach
// For every person, check if they know anyone and if everyone knows them
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to keep track of potential celebrities
// Push all people onto the stack, then pop two people at a time and check if
// one knows the other, if yes, push the one who is known back onto the stack,
// if no, push the one who doesn't know back onto the stack
// At the end, there will be one person left in the stack, check if they are a
// celebrity by checking if they know anyone and if everyone knows them
// they are a celebrity, if yes, return their index, if no, return -1
// Time complexity O(n) and space complexity O(n)