// Problem: Lowest Common Ancestor of a Binary Tree
// URL:
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
// Difficulty: Medium
// Date Solved: 2026-05-20
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }

    }
}

// NOTE:
// Think as if you are on a node, look at your children, if you find p or q,
// return that node, if you find both p and q in left and right subtree, then
// the current node is the LCA. If you find only one of them, return that one.
// If you find none, return null.
