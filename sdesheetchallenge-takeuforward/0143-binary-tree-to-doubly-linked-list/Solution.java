// Problem: Binary Tree to Doubly Linked List
// URL: https://takeuforward.org/plus/dsa/problems/binary-tree-to-doubly-linked-list?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-14

class Solution {
    TreeNode head = null;
    TreeNode prev = null;

    TreeNode bToDLL(TreeNode root) {
        if (root == null)
            return null;
        inorder(root);
        return head;
    }

    void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        inorder(node.right);
    }
}

// Approach
// Use an inorder traversal to convert the binary tree to a doubly linked list
// Keep track of the previous node and the head of the list
// link the current node with the previous node and update the previous node to
// the current node recursively call the function for the right subtree
// Time complexity O(n) and space complexity O(h) where h is height of tree