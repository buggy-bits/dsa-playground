// Problem: Kth Smallest and Largest element in BST
// URL: https://takeuforward.org/plus/dsa/problems/kth-smallest-and-largest-element-in-bst?source=strivers-sde-sheet
// Difficulty: Medium
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

    int small = -1;
    int large = -1;

    private void inorder(TreeNode root, int[] k) {
        if (root == null)
            return;

        inorder(root.left, k);

        k[0]--;
        if (k[0] == 0) {
            small = root.data;
            return;
        }

        inorder(root.right, k);
    }

    private void reverseInorder(TreeNode root, int[] k) {
        if (root == null)
            return;

        reverseInorder(root.right, k);

        k[0]--;
        if (k[0] == 0) {
            large = root.data;
            return;
        }

        reverseInorder(root.left, k);
    }

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        inorder(root, new int[] { k });
        reverseInorder(root, new int[] { k });

        List<Integer> ans = new ArrayList<>();
        ans.add(small);
        ans.add(large);
        return ans;
    }
}

// Approach

// To find the kth smallest element, perform an inorder traversal of BST,
// which visits the nodes in ascending order. keep track of the count of
// nodes visited, and when the count reaches k, its the kth smallest element.

// for kth largest element, perform a reverse inorder traversal of the BST,
// which visits the nodes in descending order. Again, keep track of the count
// of nodes visited, and when the count reaches k, its the kth largest element.

// time complexity O(h + k), where h = height of BST,
// space complexity is O(h) due to recursive call stack.