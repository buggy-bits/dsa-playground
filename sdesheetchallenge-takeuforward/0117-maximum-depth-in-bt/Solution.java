// Problem: Maximum Depth in BT
// URL: https://takeuforward.org/plus/dsa/problems/maximum-depth-in-bt?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-06

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int data) { data = data; left = null, right = null }
 * }
 **/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Approach
// Use recursion to find the maximum depth of the binary tree
// Base case: if the root is null, return 0
// Recursive case: return 1 + the maximum depth of the left and right subtrees
// Time complexity O(n) and space complexity O(h) where h is the height of tre