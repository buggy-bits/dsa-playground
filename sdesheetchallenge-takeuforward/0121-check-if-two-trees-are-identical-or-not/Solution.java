// Problem: Check if two trees are identical or not
// URL: https://takeuforward.org/plus/dsa/problems/check-if-two-trees-are-identical-or-not?source=strivers-sde-sheet
// Difficulty: Medium
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Approach
// Recursively check if both trees are null (identical), if one is null (not
// identical), and if the current nodes have the same value. Then, check the
// left and right subtrees for equality.
// Time: O(n), Space: O(h) where h is the height of tree due to recursion stack.
