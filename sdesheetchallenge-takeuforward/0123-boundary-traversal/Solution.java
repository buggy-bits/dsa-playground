// Problem: Boundary Traversal
// URL: https://takeuforward.org/plus/dsa/problems/boundary-traversal?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-07

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

    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // Add root if it is not a leaf
        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr)) {
                ans.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;

        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }

        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    private void addRightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                st.push(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
    }
}

// Approach
// Return an empty list if the tree is empty.
// Add the root (if it's not a leaf), then collect the left boundary,
// all leaf nodes, and the right boundary in reverse order.
// Time: O(n)
// Space: O(h), where h is the height of the tree.