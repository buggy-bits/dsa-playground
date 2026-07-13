// Problem: Size of the largest BST in a Binary Tree
// URL: https://takeuforward.org/plus/dsa/problems/largest-bst-in-binary-tree?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-13

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

    class NodeInfo {
        int min, max, size;

        NodeInfo(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public int largestBST(TreeNode root) {
        return helper(root).size;
    }

    private NodeInfo helper(TreeNode root) {
        if (root == null) {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        // Current subtree is a BST
        if (root.data > left.max && root.data < right.min) {
            return new NodeInfo(
                    Math.min(root.data, left.min),
                    Math.max(root.data, right.max),
                    left.size + right.size + 1);
        }

        // Not a BST
        return new NodeInfo(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.size, right.size));
    }
}

// Approach

// If the current node's value is greater than the maximum value of the left
// subtree and less than the minimum value of the right subtree, then the
// current subtree is a BST. Otherwise, return the size of the largest BST found
// in either subtree.
// Time complexity: O(n), n is the number of nodes in the tree
// Space complexity: O(h), where h is the height of the tree