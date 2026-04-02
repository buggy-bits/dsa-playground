// Problem: Search in a Binary Search Tree
// URL: https://leetcode.com/problems/search-in-a-binary-search-tree/
// Difficulty: Easy
// Date Solved: 2026-04-02

import javax.swing.tree.TreeNode;

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
    // BST has this property that
    // all nodes of left subtree of root will be smaller than root
    // all nodes ofright subtree will be greater than root.

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else if (root.val == val) {
                return root;
            }
        }
        return null;
    }
}
