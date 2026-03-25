// Problem: Maximum Twin Sum of a Linked List
// URL: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
// Difficulty: Medium
// Date Solved: 2026-03-25

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
    public int pairSum(ListNode head) {
        // NOTE:
        // Reverse the first half of the linked list
        // do the sum from the middle to the end for both halves
        // do sum and find max value
        // easy af
        // O(n) time and O(1) space

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        int maxVal = 0;

        while (prev != null && slow != null) {
            maxVal = Math.max(maxVal, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }

        return maxVal;

    }
}
