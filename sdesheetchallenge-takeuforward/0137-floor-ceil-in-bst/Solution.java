// Problem: Floor & Ceil in BST
// URL: https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-a-bst?source=strivers-sde-sheet
// Difficulty: Easy
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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {

        int floor = -1;
        int ceil = -1;

        while (root != null) {
            if (root.data == key) {
                floor = key;
                ceil = key;
                break;
            } else if (key < root.data) {
                ceil = root.data;
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(floor);
        ans.add(ceil);

        return ans;
    }
}

// Approach
// Use a while loop to traverse the BST. If the current node's value is equal to
// the key, set both floor and ceil to the key. If the key is less than the
// current node's value, update ceil and move to the left child. If the key is
// greater than current node's value, update floor and move to right child.
// Time complexity: O(h), where h is the height of the tree
// Space complexity: O(1)