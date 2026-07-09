// Problem: Symmetric Binary Tree
// URL: https://takeuforward.org/plus/dsa/problems/check-for-symmetrical-bts?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-09

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return (left.data == right.data) &&
                isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);
    }
}

// Approach
// Use a helper function to check if two trees are mirror images of each other.
// Recursively compare the left subtree of one tree with the right subtree of
// the other tree and vice versa. If both subtrees are null, they are mirrors.
// If one is null and the other is not, they are not mirrors. If the values of
// the current nodes are equal, continue checking their children.
// Time complexity: O(n), where n is the number of nodes in the tree.