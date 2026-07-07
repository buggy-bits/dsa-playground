// Problem: Zig Zag or Spiral Traversal
// URL: https://takeuforward.org/plus/dsa/problems/zig-zag-or-spiral-traversal?source=strivers-sde-sheet
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    TreeNode curr = q.pollFirst();
                    current.add(curr.val);
                    if (curr.left != null)
                        q.addLast(curr.left);
                    if (curr.right != null)
                        q.addLast(curr.right);
                } else {
                    TreeNode curr = q.pollLast();
                    current.add(curr.val);
                    if (curr.right != null)
                        q.addFirst(curr.right);
                    if (curr.left != null)
                        q.addFirst(curr.left);
                }
            }

            res.add(current);
            reverse = !reverse;
        }

        return res;
    }
}

// Approach
// Use a deque to perform a level order traversal of the binary tree. For each
// level, if the reverse flag is false, add the nodes from left to right. If
// the reverse flag is true, add the nodes from right to left. Toggle the
// reverse flag after each level. This ensures that the nodes are added in a
// zigzag manner.
// Time complexity is O(n) where n is the number of nodes
// space complexity is O(n) for the deque and result list.