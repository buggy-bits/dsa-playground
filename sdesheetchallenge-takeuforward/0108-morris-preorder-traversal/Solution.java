// Problem: Morris Preorder Traversal
// URL: https://takeuforward.org/plus/dsa/problems/morris-preorder-traversal-?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-04

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
    public List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    ans.add(curr.data); // Visit before going left
                    pred.right = curr; // Create thread
                    curr = curr.left;
                } else {
                    pred.right = null; // Remove
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}

// Approach
// start from the root and traverse the tree using a while loop. If the current
// node has no left child, visit it and move to its right child. If it has a
// left child, find its inorder predecessor (the rightmost node in the left
// subtree). If the predecessor's right child is null, create a thread to the
// current node, visit the current node, and move to its left child. If the
// predecessor's right child is already pointing to the current node, remove the
// thread and move to the current node's right child. Repeat until all nodes are
// visited.
// O(n) time complexity, Space Complexity O(1) space