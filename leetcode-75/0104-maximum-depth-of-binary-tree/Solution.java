// Problem: Maximum Depth of Binary Tree
// URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Difficulty: Easy
// Date Solved: 2026-03-25
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return treeDfs(root);
    }

    // NOTE
    // Using Recursion as it acts like a stack and easily travel in depth
    private int treeDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDfs(root.left);
        int right = treeDfs(root.right);
        return 1 + Math.max(left, right);
    }
}