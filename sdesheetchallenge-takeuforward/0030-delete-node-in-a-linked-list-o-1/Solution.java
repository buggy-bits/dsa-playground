// Problem: Delete Node in a Linked List O(1)
// URL: https://takeuforward.org/plus/dsa/problems/delete-node-in-a-linked-list-o1?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-10

// Time complexity O(1) and space complexity O(1)

// Given a node to be deleted, 
// Also this node is not the tail for sure

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// Brute force approach
// start from the given node,
// change the node value to the next node value,
// do it till the end and remove the tail node
// Time complexity O(n) and space complexity O(1)