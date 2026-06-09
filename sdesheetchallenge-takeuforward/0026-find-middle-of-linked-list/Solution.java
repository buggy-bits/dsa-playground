// Problem: Find Middle of Linked List
// URL: https://takeuforward.org/plus/dsa/problems/find-middle-of-linked-list?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-09

class Solution {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        if (fast.next == null) {

            return slow;
        }
        return slow.next;
    }
}

// Brute force approach
// Count the number of nodes in the linked list,
// iterate again to the middle node and return it
// Time complexity O(n) and space complexity O(1)

// Optimal approach
// Use 2 pointers, one slow and one fast,
// move the slow pointer by 1 ,fast pointer by 2,
// when the fast pointer reaches the end of the linked list,
// the slow pointer will be at the middle node, return the slow pointer
// Time complexity O(n) and space complexity O(1)
