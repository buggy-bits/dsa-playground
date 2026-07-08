// Problem: Construct a BT from Preorder and Inorder
// URL: https://takeuforward.org/plus/dsa/problems/construct-a-bt-from-preorder-and-inorder?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-08

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

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }
}

// Approach
// Use a HashMap to store the indices of inorder elements for quick access.
// Start from the first index of preorder (which is the root) and recursively
// build the left and right subtrees using the indices from the inorder array.
// Time complexity O(n) and space complexity O(n)
// n = number of nodes in the tree