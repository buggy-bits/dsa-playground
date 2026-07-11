// Problem: LCA in BST
// URL: https://takeuforward.org/plus/dsa/problems/lca-in-bst?source=strivers-sde-sheet
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
    public TreeNode lca(TreeNode root, int p, int q) {
        while (root != null) {
            if (p < root.data && q < root.data) {
                root = root.left;
            } else if (p > root.data && q > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}

// Approach
// Start from the root and traverse the BST.
// If both p and q are smaller than the current node's value, move left.
// If both are greater, move right.
// If one is on the left and the other is on the right, the current node is LCA
// Time complexity: O(h), h height of tree
// Space complexity: O(1) no recursive stack