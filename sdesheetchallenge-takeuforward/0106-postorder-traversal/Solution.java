// Problem: Postorder Traversal
// URL: https://takeuforward.org/plus/dsa/problems/postorder-traversal?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-03

class Solution {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.left, result);
        postorderTraversal(node.right, result);
        result.add(node.data);
    }
}

// approach
// Use a recursive approach to traverse the tree in postorder and add the node
// values to a list, then return the list
// Time complexity O(n) and space complexity O(n)
