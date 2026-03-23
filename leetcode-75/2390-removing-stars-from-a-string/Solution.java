// Problem: Removing Stars From a String
// URL: https://leetcode.com/problems/removing-stars-from-a-string
// Difficulty: Medium
// Date Solved: 2026-03-23

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        char[] myArre = s.toCharArray();
        int n = myArre.length;
        ;
        int flags = 0;
        Stack<Character> myStack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            if (flags > 0 && myArre[i] != '*') {
                flags--;
                continue;
            }

            if (myArre[i] != '*') {
                myStack.add(myArre[i]);
            } else {
                flags++;
            }

        }

        StringBuilder ans = new StringBuilder();

        while (!myStack.isEmpty()) {
            ans.append(myStack.pop());
        }

        return ans.toString();
    }
}
