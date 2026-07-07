// Problem: LCA in BT
// URL: https://takeuforward.org/plus/dsa/problems/lca-in-bt?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-07

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}

// Approach
// Recursively search the left and right subtrees.
// If the current node is null or matches p or q, return it.
// If both sides return non-null, the current node is the LCA;
// otherwise, return the non-null result.
// Time: O(n)
// Space: O(h)