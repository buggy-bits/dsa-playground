// Problem: Construct a BT from Postorder and Inorder
// URL: https://takeuforward.org/plus/dsa/problems/construct-a-bt-from-postorder-and-inorder?source=strivers-sde-sheet
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
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        root.right = build(postorder, inIndex + 1, inEnd);

        // Build left subtree
        root.left = build(postorder, inStart, inIndex - 1);

        return root;
    }
}

// Approach
// Use a HashMap to store the indices of inorder elements for quick access.
// Start from the last index of postorder (which is the root) and recursively
// build the right and left subtrees using the indices from the inorder array.
// Time complexity O(n) and space complexity O(n)
// n = number of nodes in the tree
