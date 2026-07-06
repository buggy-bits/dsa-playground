// Problem: Diameter of Binary Tree
// URL: https://takeuforward.org/plus/dsa/problems/diameter-of-binary-tree?source=strivers-sde-sheet
// Difficulty: Easy
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
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
}

// @formatter:off
// Approach
// Use recursion to traverse the binary tree and calculate the diameter
// Start from the root and calculate the height of left and right subtrees
// The diameter at each node is the sum of the heights of left and right subtrees
// Update the maximum diameter found so far, return the height of the current node to its parent
// Time complexity O(n) and space complexity O(h) where h is the height of the
