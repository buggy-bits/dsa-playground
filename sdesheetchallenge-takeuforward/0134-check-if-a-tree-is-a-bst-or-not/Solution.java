// Problem: Check if a tree is a BST or not
// URL: https://takeuforward.org/plus/dsa/problems/check-if-a-tree-is-a-bst-or-not?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-11

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public boolean isBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return validate(node.left, min, node.data) &&
               validate(node.right, node.data, max);
    }
}


// Approach
// Use a recursive function to validate the BST property for each node.
// For each node, check if its value is within the valid range (min, max).
// If it is, recursively check its left and right subtrees with updated ranges.
// Time complexity: O(n), n is the number of nodes in tree
// Space complexity: O(h), where h is height of the tree 