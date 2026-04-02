// Problem: Longest ZigZag Path in a Binary Tree
// URL: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// Difficulty: Medium
// Date Solved: 2026-04-02

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
    static int ans = 0;

    public int longestZigZag(TreeNode root) {
        ans = 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        solve(root.left, 1, true);
        solve(root.right, 1, false);

        return ans;
    }

    public static void solve(TreeNode root, int len, boolean leftdir) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, len);
        if (leftdir) {
            solve(root.right, len + 1, false);
            solve(root.left, 1, true);
        } else {
            solve(root.left, len + 1, true);
            solve(root.right, 1, false);
        }
    }
}
