// Problem: Two sum in BST
// URL: https://takeuforward.org/plus/dsa/problems/two-sum-in-bst?source=strivers-sde-sheet
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

    class BSTIterator {
        Stack<TreeNode> st = new Stack<>();
        boolean reverse;

        BSTIterator(TreeNode root, boolean reverse) {
            this.reverse = reverse;
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                st.push(node);
                if (reverse)
                    node = node.right;
                else
                    node = node.left;
            }
        }

        int next() {
            TreeNode node = st.pop();

            if (reverse)
                pushAll(node.left);
            else
                pushAll(node.right);

            return node.data;
        }
    }

    public boolean twoSumBST(TreeNode root, int k) {
        if (root == null)
            return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k)
                return true;
            else if (sum < k)
                i = left.next();
            else
                j = right.next();
        }

        return false;
    }
}

// Approach
// Use two iterators, one for the smallest element and one for the largest
// element
// Move the iterators towards each other until they meet or find the target sum
// Time complexity O(n) and space complexity O(h) where n is the number of nodes
// in the tree and h is the height of the tree