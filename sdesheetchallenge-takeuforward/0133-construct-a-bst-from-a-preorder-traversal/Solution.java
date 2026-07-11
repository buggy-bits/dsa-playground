// Problem: Construct a BST from a preorder traversal
// URL: https://takeuforward.org/plus/dsa/problems/construct-a-bst-from-a-preorder-traversal?source=strivers-sde-sheet
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
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = build(preorder, root.data);
        root.right = build(preorder, bound);

        return root;
    }
}

// Approach
// Use a recursive function to build the BST from the preorder traversal.
// Maintain an index to track the current position in the preorder array and a
// bound to ensure the BST property is maintained.
// If the current value exceeds the bound, return null.
// Time complexity: O(n), n is the number of nodes in the tree
// Space complexity: O(h), where h is the height of tree