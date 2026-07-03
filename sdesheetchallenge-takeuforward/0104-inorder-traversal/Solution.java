// Problem: Inorder Traversal
// URL: https://takeuforward.org/plus/dsa/problems/inorder-traversal?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-03

class Solution {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, result);
        result.add(node.data);
        inorderTraversal(node.right, result);
    }
}

// Approach
// Use recursion to traverse the binary tree in inorder (left, root, right)
// Time complexity O(n) and space complexity O(h) where h is the height of the
// tree due to the recursion stack
