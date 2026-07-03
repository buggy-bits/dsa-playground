// Problem: Morris Inorder Traversal
// URL: https://takeuforward.org/plus/dsa/problems/morris-inorder-traversal-?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-03

class Solution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // If there is no left child, visit current node
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            } else {
                // Find the inorder predecessor
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create a temporary thread
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                // Thread already exists, remove it and visit current
                else {
                    prev.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}

// Brute force approach
// Use recursion or a stack to perform an inorder traversal of the binary tree
// and store the values in a list.
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// start from the root and keep moving to the left child until you reach a node
// with no left child. At this point, visit the node and move to its right
// child. If the right child is null, backtrack to the parent node and repeat
// the process. This can be done using a while loop and without using any extra
// space for recursion or a stack.
// Time complexity O(n) and space complexity O(1)
