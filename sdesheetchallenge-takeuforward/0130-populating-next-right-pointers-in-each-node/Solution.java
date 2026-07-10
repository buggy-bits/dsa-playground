// Problem: Populating Next Right Pointers in Each Node
// URL: https://takeuforward.org/plus/dsa/problems/populating-next-right-pointers-in-each-node?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-10

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            // Connect left child to right child
            root.left.next = root.right;

            // Connect right child to the next subtree's left child
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}

// Approach
// Use a recursive approach to connect the next pointers of each node. For each
// node, connect its left child to its right child, and if the node has a next
// pointer, connect its right child to the left child of the next node. Then
// recursively call the function for the left and right children.
// time complexity is O(n). space complexity is O(h) recursion stack,
// n is the number of nodes in the tree
// h is the height of tree.