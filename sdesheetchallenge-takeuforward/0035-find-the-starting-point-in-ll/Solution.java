// Problem: Find the starting point in LL
// URL: https://takeuforward.org/plus/dsa/problems/find-the-starting-point-in-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-12

class Solution {
    public ListNode findStartingPoint(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < 0) {
                curr.val *= -1;
                return curr;
            }
            curr.val *= -1;
            curr = curr.next;
        }
        return null;
    }
}

// Brute force approach
// Use a hash set to store the nodes of the linked list,
// iterate untill you find a node that is already in the set
// if you find null, no loop, return null
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// Use the linked list itself to mark visited nodes,
// iterate through the list and mark the value of each node as negative,
// if you find a node with negative value,it is the starting point
// make its value positive, return that node
// if you find null, no loop, return null
// Time complexity O(n) and space complexity O(1)