// Problem: Check if LL is palindrome or not
// URL: https://takeuforward.org/plus/dsa/problems/check-if-ll-is-palindrome-or-not?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-12

class Solution {

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverseList(slow.next);
        slow.next = null;
        while (rev != null) {
            if (head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;

    }
}

// Brute force approach
// Use a stack to store the values of the linked list,
// iterate through the list and push the values onto the stack,
// iterate through the list again and compare the values with the top of the
// stack,
// Time complexity O(n) and space complexity O(n)

// optimal approach
// Use the fast and slow pointer technique to find the middle of the linked
// list,
// reverse the second half of the linked list,
// iterate through the first half and the reversed second half of linked list,
// compare the values of the nodes,
// if any value is different, return false,
// if all values are same, return true
// Time complexity O(n) and space complexity O(1)