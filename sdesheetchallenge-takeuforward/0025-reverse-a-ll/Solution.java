// Problem: Reverse a LL
// URL: https://takeuforward.org/plus/dsa/problems/reverse-a-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-09

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode a = null;
        ListNode b = head;
        while (b != null) {
            ListNode c = b.next;

            b.next = a;
            head = a;
            a = b;
            b = c;
        }

        return a;
    }
}

// Brute force approach
// Use a stack to store the nodes of the linked list, then pop the nodes and
// create a new linked list in reverse order
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// Use 3 pointers, one to store the previous node, one to store the current node
// and one to store the next node, iterate through the linked list, update the
// next pointer of the current node to point to the previous node, move the
// pointers one step forward, at the end return the previous node as new head
// Time complexity O(n) and space complexity O(1)