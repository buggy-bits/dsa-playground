// Problem: Search in BST
// URL: https://takeuforward.org/plus/dsa/problems/search-in-bst?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-10

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
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.data == val) {
                return root;
            } else if (val < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}

// Approach
// Use an iterative approach to traverse the BST. Start from the root and
// compare
// the current node's value with the target value. If they are equal, return the
// current node. If the target value is less than the current node's value, move
// to the left child; otherwise, move to the right child. Repeat this process
// until the target value is found or the end of the tree is reached. The time
// complexity is O(h), space complexity is O(1).
// h is the height of the tree,