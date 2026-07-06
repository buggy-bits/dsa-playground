// Problem: Level Order Traversal
// URL: https://takeuforward.org/plus/dsa/problems/level-order-traversal?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-06

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> myQ = new LinkedList<>();

        myQ.add(root);

        while (!myQ.isEmpty()) {
            int n = myQ.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                TreeNode myNode = myQ.poll();
                if (myNode.left != null) {
                    myQ.add(myNode.left);
                }
                if (myNode.right != null) {
                    myQ.add(myNode.right);
                }
                level.add(myNode.data);
            }
            ans.add(level);
        }
        return ans;
    }
}

// @formatter:off
// Approach
// Use a queue to perform a breadth-first traversal of the binary tree
// For each level, store the values of the nodes in a list and add it to the result
// Time complexity O(n) and space complexity O(n) where n is the number of nodes in the tree
