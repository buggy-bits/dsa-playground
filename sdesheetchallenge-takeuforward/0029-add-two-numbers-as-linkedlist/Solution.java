// Problem: Add two numbers as LinkedList
// URL: https://takeuforward.org/plus/dsa/problems/add-two-numbers-in-ll?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-10

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.data;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }
}

// Brute force approach
// Convert both linked lists to numbers, add the two numbers
// convert the result back to a linked list
// Time complexity O(n+m) and space complexity O(n+m)

// Optimal approach
// Traverse both linked lists at the same time,
// add the corresponding digits and carry
// reuse a linked list to store the result
// Time complexity O(max(n,m)) and space complexity O(max(n,m))