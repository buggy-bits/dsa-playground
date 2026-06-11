// Problem: Find the intersection point of Y LL
// URL: https://takeuforward.org/plus/dsa/problems/find-the-intersection-point-of-y-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-11

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}

// Brute force approach
// Use 2 nested loops to compare each node of the first list with each node of
// the second list, if a match is found, return the node
// Time complexity O(m*n) and space complexity O(1)

// Optimal approach
// Use 2 pointers to traverse both lists, when one pointer reaches the end of a
// list, redirect it to the head of the other list, if intersection exists,
// they will meet at the intersection point after at most 2 passes,
// else they meet at null (both pointers)
// Time complexity O(m+n) and space complexity O(1)