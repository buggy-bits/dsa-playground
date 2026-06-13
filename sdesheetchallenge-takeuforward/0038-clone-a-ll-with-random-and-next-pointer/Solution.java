// Problem: Clone a LL with random and next pointer
// URL: https://takeuforward.org/plus/dsa/problems/clone-a-ll-with-random-and-next-pointer?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-13

class Solution {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;

        while (curr != null) {
            ListNode copy = new ListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        ListNode dummy = new ListNode(0);
        ListNode copyCurr = dummy;

        while (curr != null) {
            ListNode copy = curr.next;
            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }
}

// Brute force approach
// Use a hash map to store the mapping of original nodes to their copies,
// iterate through the original list and create copies of the nodes,
// store the mapping in the hash map,
// iterate through the original list again and set the next and random pointers
// of the copied nodes using the hash map,
// Time complexity O(n) and space complexity O(n)

// @formatter:off
// Optimal approach
// Interleave the copied nodes with the original nodes,
// iterate through the original list and create copies of the nodes,
// insert the copied nodes between the original nodes,
// iterate through the original list again and set the random pointers of the copied nodes,
// if the random pointer of the original node is not null, set the random pointer of the
// copied node to the next of the random pointer of the original node,
// iterate through the original list again and restore the original list and extract the copied list,
// Time complexity O(n) and space complexity O(1) (excluding space for result)