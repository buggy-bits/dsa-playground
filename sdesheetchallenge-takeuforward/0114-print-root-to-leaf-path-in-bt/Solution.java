// Problem: Print root to leaf path in BT
// URL: https://takeuforward.org/plus/dsa/problems/print-root-to-note-path-in-bt?source=strivers-sde-sheet
// Difficulty: Medium
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

    List<List<Integer>> result = new ArrayList<>();

    private void dfs(TreeNode root, List<Integer> path) {
        if (root == null)
            return;

        // add current node
        path.add(root.data);

        // if leaf node → store path
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            // explore children
            dfs(root.left, path);
            dfs(root.right, path);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        dfs(root, new ArrayList<>());
        return result;
    }
}

// Approach
// Use DFS to traverse the tree and store the path from root to leaf nodes
// Backtrack to remove the last node from the path when returning from recursion
//
// Time complexity O(n) and space complexity O(h) where h is the height of tree