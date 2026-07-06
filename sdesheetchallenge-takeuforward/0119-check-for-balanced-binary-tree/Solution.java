// Problem: Check for balanced binary tree
// URL: https://takeuforward.org/plus/dsa/problems/check-for-balanced-binary-tree?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-06

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isHeight(root) != -1;
    }

    public int isHeight(TreeNode root) {
        if (root == null)
            return 0;

        int lh = isHeight(root.left);
        if (lh == -1)
            return -1;

        int rh = isHeight(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }
}

// Approach
// Use a recursive function to calculate the height of the tree. If at any
// point, the difference between the heights of the left and right subtrees is
// greater than 1, return -1 to indicate that the tree is not balanced.
// Otherwise, return the height of the tree. The main function checks if the
// result is -1 to determine if the tree is balanced.

// Time complexity O(n) and space complexity O(h) where h is the height of the