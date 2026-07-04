// Problem: Bottom view of BT
// URL: https://takeuforward.org/plus/dsa/problems/bottom-view-of-bt?source=strivers-sde-sheet
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

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int hd = curr.hd;

            // Always update the latest node for this horizontal distance
            map.put(hd, node.data);

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        ans.addAll(map.values());
        return ans;
    }
}

// Approach
// Use level order traversal (BFS) to traverse the tree. For each node, keep
// track of its horizontal distance from the root in a TreeMap. For each
// horizontal distance, always update the value with the latest node encountered
// at that distance. After the traversal, the TreeMap will contain the bottom
// view of the tree. The keys in the TreeMap represent horizontal distances, and
// the values represent the corresponding node values. Finally, return the
// values of the TreeMap as a list.

// time complexity is O(n log n) due to the TreeMap operations, and space
// complexity is O(n) for the queue and map.