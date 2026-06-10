// Problem: Remove Nth node from the back of the LL
// URL: https://takeuforward.org/plus/dsa/problems/remove-nth-node-from-the-back-of-the-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-10

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        if (head.next == null && n > 0) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;

        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}

// Brute force approach
// Calculate the length of the linked list, then find the node to be removed and
// remove it
// Time complexity O(n) and space complexity O(1)

// Optimal approach
// Use two pointers, one to move n steps ahead and other to start from head,
// move both pointers one step at a time until the first pointer reaches end,
// at this point second pointer will be at the node to be removed, remove it
// return the head

// Time complexity O(n) and space complexity O(1)
// same complexity as brute force, but faster.