// Problem: Detect a loop in LL
// URL: https://takeuforward.org/plus/dsa/problems/detect-a-loop-in-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-11

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

// Brute force approach
// Use a hash set to store the nodes of the linked list,
// iterate untill you find a node that is already in the set
// if you find null, no loop, return false
// Time complexity O(n) and space complexity O(n)

// Optimal approach
// Use two pointers, one slow and one fast, move slow by one step and fast by
// two steps, if there is a loop, they will meet at some point,
// if not, fast will reach null, return false
// Time complexity O(n) and space complexity O(1)