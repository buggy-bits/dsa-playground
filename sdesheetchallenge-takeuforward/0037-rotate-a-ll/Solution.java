// Problem: Rotate a LL
// URL: https://takeuforward.org/plus/dsa/problems/rotate-a-ll?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-13

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;
        if (k == 0) {
            return head;
        }

        tail.next = head;

        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}

// Brute force approach
// Rotate the linked list by k nodes, for this we can use a loop to move the
// last node to the front of the linked list k times
// Time complexity O(n*k) and space complexity O(1)

// @formatter:off
// Optimal approach
// First, find the length of the linked list and connect the tail to the head to
// make it a circular linked list, then calculate the effective rotations needed
// by taking k modulo length, then find the new tail which is (length - k) nodes
// from the head, and the new head which is the next node of the new tail,
// finally break the circular linked list by setting the next of the new tail to null
// Time complexity O(n) and space complexity O(1)
