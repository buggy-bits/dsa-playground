// Problem: Right/Left View of BT
// URL: https://takeuforward.org/plus/dsa/problems/right-left-view-of-bt?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-04

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                // Last node of the current level
                if (i == size - 1) {
                    ans.add(node.data);
                }
            }
        }

        return ans;
    }
}

// Approach
// Use level order traversal (BFS) to traverse the tree level by level. For each
// level, add the last node's value to the result list. This ensures that we get
// the rightmost node at each level, which constitutes the right view of tree.
// Time complexity is O(n) where n is the number of nodes in the tree, and space