// Problem: Flatten Binary Tree to Linked List
// URL: https://takeuforward.org/plus/dsa/problems/flatten-binary-tree-to-linked-list?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-09

/* class TreeNode {
       int val;
       TreeNode left, right;
       TreeNode(int x) { val = x; }
   }
*/

class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// Approach
// Use a recursive approach to flatten the binary tree in a reverse preorder
// manner (right, left, root). Keep track of the previous node and set the
// current node's right child to the previous node
// and left child to null. Update the previous node to the current node.
// Time complexity O(n) and space complexity O(h) where h is the height of the