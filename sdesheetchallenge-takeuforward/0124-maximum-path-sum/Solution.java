// Problem: Maximum path sum
// URL: https://takeuforward.org/plus/dsa/problems/maximum-path-sum-?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-08

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int data;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int val) {
 * data = val;
 * left = null;
 * right = null;
 * }
 * }
 **/

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Maximum path passing through current node
        maxSum = Math.max(maxSum, node.data + left + right);

        // Return maximum gain to parent
        return node.data + Math.max(left, right);
    }
}

// Approach
// Use depth-first search (DFS) to traverse the binary tree.
// For each node, calculate the maximum path sum that can be obtained by
// including the node and its left and right children.
// Update the global maximum path sum if the current path sum is greater.
// Return the maximum gain to the parent node, which is the node's value
// plus the maximum of the left and right gains.
// Time complexity: O(n), where n is the number of nodes in the tree.
// Space complexity: O(h), where h is the height of the tree.
