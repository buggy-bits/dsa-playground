// Problem: Inorder successor and predecessor in BST
// URL: https://takeuforward.org/plus/dsa/problems/inorder-successor-and-predecessor-in-bst?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-11

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    List<Integer> succPredBST(TreeNode root, int key) {
        Integer pred = -1, succ = -1;
        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.data) {
                succ = curr.data;
                curr = curr.left;
            } else if (key > curr.data) {
                pred = curr.data;
                curr = curr.right;
            } else {
                // Find predecessor
                TreeNode temp = curr.left;
                while (temp != null) {
                    pred = temp.data;
                    temp = temp.right;
                }

                // Find successor
                temp = curr.right;
                while (temp != null) {
                    succ = temp.data;
                    temp = temp.left;
                }
                break;
            }
        }

        return Arrays.asList(pred, succ);
    }
}

// Approach
// Traverse the BST to find the node with the given key.
// If the key is less than the current node's value, update successor and move left.
// If the key is greater, update predecessor and move right.
// If the key is found, find the maximum value in the left subtree for predecessor
// and the minimum value in the right subtree for successor.
// Time complexity: O(h), h is the height of tree
// Space complexity: O(1) no recursive stack 