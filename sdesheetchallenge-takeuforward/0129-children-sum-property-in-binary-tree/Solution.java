// Problem: Children Sum Property in Binary Tree
// URL: https://takeuforward.org/plus/dsa/problems/children-sum-property-in-binary-tree?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-09

// class TreeNode {
//     int val;
//     TreeNode left, right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    boolean checkChildrenSum(TreeNode root) {
        // Empty tree or leaf node satisfies the property
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftVal = (root.left != null) ? root.left.val : 0;
        int rightVal = (root.right != null) ? root.right.val : 0;

        // Check current node and recursively check subtrees
        return (root.val == leftVal + rightVal)
                && checkChildrenSum(root.left)
                && checkChildrenSum(root.right);
    }
}

// Approach
// Use recursion to check if the current node's value is equal to the sum of its
// children's values and recursively check the left and right subtrees.
// Time complexity O(n) and space complexity O(h) where h is the height of the