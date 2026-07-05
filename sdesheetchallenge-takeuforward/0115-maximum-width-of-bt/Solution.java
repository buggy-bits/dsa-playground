// Problem: Maximum Width of BT
// URL: https://takeuforward.org/plus/dsa/problems/maximum-width-of-bt?source=strivers-sde-sheet
// Difficulty: Medium
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

    class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long minIdx = q.peek().idx; // normalize level
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                long idx = cur.idx - minIdx;

                if (i == 0)
                    first = idx;
                if (i == size - 1)
                    last = idx;

                if (cur.node.left != null) {
                    q.offer(new Pair(cur.node.left, 2 * idx));
                }

                if (cur.node.right != null) {
                    q.offer(new Pair(cur.node.right, 2 * idx + 1));
                }
            }

            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
    }
}

// @formatter:off
// approach
// Use level order traversal and for each level, find the first and last node's index
// then calculate the width of that level and keep track of the maximum width
// Time complexity O(n) and space complexity O(n)