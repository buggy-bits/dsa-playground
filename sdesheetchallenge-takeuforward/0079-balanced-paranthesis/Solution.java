// Problem: Balanced Paranthesis
// URL: https://takeuforward.org/plus/dsa/problems/balanced-paranthesis?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-25

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

// Brute force approach
// For each opening bracket, find the corresponding closing bracket and remove
// them from the string, if at the end the string is empty, return true, else
// return false
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a stack to keep track of the opening brackets, traverse the string, for
// each character, if it is an opening bracket, push the corresponding closing
// bracket to the stack, if it is a closing bracket, check if the stack is empty
// or if the top of the stack is not equal to the current character, if either
// is true, return false, else pop the top of the stack, at the end, if the
// stack is empty, return true, else return false
// Time complexity O(n) and space complexity O(n)