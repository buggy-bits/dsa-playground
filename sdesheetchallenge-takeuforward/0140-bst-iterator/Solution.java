// Problem: BST iterator
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

class BSTIterator {

    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.data;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// Approach
// Use a stack to simulate the inorder traversal of the BST. Push all the left
// children of the current node onto the stack. When next() is called, pop the
// top node from the stack, push its right child and all its left children onto
// the stack, and return the value of the popped node. hasNext() checks if the
// stack is empty or not.
// Time complexity O(1) for next() and hasNext(), and
// space complexity O(h) where h is the height of the tree.