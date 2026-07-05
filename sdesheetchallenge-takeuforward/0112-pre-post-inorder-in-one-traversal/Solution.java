// Problem: Pre, Post, Inorder in one traversal
// URL: https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal?source=strivers-sde-sheet
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

    List<Integer> preorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        // Preorder
        preorder.add(root.data);

        dfs(root.left);

        // Inorder
        inorder.add(root.data);

        dfs(root.right);

        // Postorder
        postorder.add(root.data);
    }

    List<List<Integer>> treeTraversal(TreeNode root) {
        dfs(root);

        List<List<Integer>> result = new ArrayList<>();
        result.add(inorder);
        result.add(preorder);
        result.add(postorder);

        return result;
    }
}

// @formatter:off
// Approach
// Use DFS to traverse the tree and store the nodes in preorder, inorder, and postorder lists
// then return the lists in a list of lists
// Time complexity O(n) and space complexity O(n) where n is the number of nodes in the tree