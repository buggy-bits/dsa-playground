// Problem: Serialize and De-serialize BT
// URL: https://takeuforward.org/plus/dsa/problems/serialize-and-de-serialize-bt?source=strivers-sde-sheet
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
class Solution {

    // Encodes a tree to a string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.data).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes the string back to a tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}

/*
 * Your Codec object will be instantiated and called as such:
 * Codec ser = new Codec();
 * Codec deser = new Codec();
 * String tree = ser.serialize(root);
 * TreeNode ans = deser.deserialize(tree);
 * return ans;
 */

// Approach
// Use level order traversal to serialize the tree. For each node, if it is
// null, append "null" to the string. Otherwise, append the node's value and add
// its children to the queue. To deserialize, split the string by commas and use
// a queue to reconstruct the tree. For each node, if the next value is not
// "null", create a new node and add it as the left child. Repeat for the right
// child.
// Time complexity: O(n), n is the number of nodes in the tree
// Space complexity: O(n), for storing the serialized string and the queue