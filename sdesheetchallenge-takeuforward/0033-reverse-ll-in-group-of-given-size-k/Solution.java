// Problem: Reverse LL in group of given size K
// URL: https://takeuforward.org/plus/dsa/problems/reverse-ll-in-group-of-given-size-k?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-11

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        // Check if there are at least k nodes
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, reverse them
        if (count == k) {
            ListNode prev = reverseKGroup(curr, k); // reverse remaining list

            curr = head;
            while (count-- > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head = prev;
        }

        return head;
    }
}

// Brute force approach
// Reverse the linked list in groups of size k, for this we can use a stack to
// store the nodes of the current group, then pop them and reverse the links
// Time complexity O(n) and space complexity O(k)

// Optimal approach
// Use recursion to reverse the linked list in groups of size k, first check if
// there are at least k nodes, if yes, reverse the first k nodes and recursively
// call the function for the remaining list,
// then connect the reversed group with the reversed remaining list
// Time complexity O(n) and space complexity O(1) (ignoring recursive stack)