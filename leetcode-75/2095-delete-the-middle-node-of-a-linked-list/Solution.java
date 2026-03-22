// Problem: Delete the Middle Node of a Linked List
// URL: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
// Difficulty: Medium
// Date Solved: 2026-03-23

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) { // only 1 node
            return null;
        }
        int n = 0;
        ListNode runner = head;
        while (runner != null) {
            n++;
            runner = runner.next;
        }
        int middle;
        if (n % 1 != 0) {// odd
            middle = (n - 1) / 2;
        } else {
            middle = n / 2;
        }

        ListNode prev = null;
        runner = head;
        for (int i = 0; i < middle; i++) {
            prev = runner;
            runner = runner.next;
        }
        if (prev != null)
            prev.next = runner.next;

        return head;
    }
}