// Problem: Construct BST from given keys
// URL: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
// Difficulty: Easy
// Date Solved: 2026-07-10

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);

        return root;
    }
}

// Approach
// Use a recursive approach to build the BST. The middle element of the current
// subarray is chosen as the root, and the left and right subarrays are used to
// build the left and right subtrees, respectively. This ensures that the tree
// remains balanced.
// The time complexity is O(n) and the space complexity is O(log n) due to the
// recursion stack, where n is the number of nodes in the tree.