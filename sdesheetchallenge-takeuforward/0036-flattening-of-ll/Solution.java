// Problem: Flattening of LL
// URL: https://takeuforward.org/plus/dsa/problems/flattening-of-ll?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-12

/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
class Solution {

    public ListNode flattenLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Flatten the remaining lists on the right
        head.next = flattenLinkedList(head.next);

        // Merge current list with flattened right side
        ListNode mergedHead = mergeTwoLists(head, head.next);

        return mergedHead;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val <= list2.val) {

            ListNode nextChild = mergeTwoLists(list1.child, list2);

            list1.child = nextChild;
            list1.next = null; // remove horizontal link

            return list1;

        } else {

            ListNode nextChild = mergeTwoLists(list1, list2.child);

            list2.child = nextChild;
            list2.next = null; // remove horizontal link

            return list2;
        }
    }
}

// Brute force approach
// Use an array to store all nodes,
// sort the array,
// create a new linked list using the sorted array
// Time complexity O(n log n) and space complexity O(n)

// Optimal approach
// Use recursion to flatten the linked list, first flatten the right side of the
// list, then merge the current list with the flattened right side using
// a helper function that merges two sorted linked lists, while merging, remove
// the horizontal links and only keep the vertical links
// Time complexity O(n) and space complexity O(1) (ignoring recursive stack)