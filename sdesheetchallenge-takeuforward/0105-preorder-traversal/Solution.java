// Problem: Preorder Traversal
// URL: https://takeuforward.org/plus/dsa/problems/preorder-traversal?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-07-03

class Solution {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.data);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}

// Approach
// Use recursion to traverse the binary tree in preorder (root, left, right)
// Time complexity O(n) and space complexity O(h) where h is the height of the
// tree due to the recursion stack
