// Problem: Merge two Sorted Lists
// URL: https://takeuforward.org/plus/dsa/problems/merge-sorted-lists-?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-09

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }
}

// Brute force approach
// Create a new list, compare the elements of both lists, add the smaller one
// to the new list, move the pointer of the list from which the element is added
// Time complexity O(m+n) and space complexity O(m+n)

// Optimal approach
// Use a dummy node to create a new list, compare the elements of both lists
// add the smaller one to the new list, move the pointer of the list from which
// the element is added,at the end attach the remaining nodes of non empty list
// Time complexity O(m+n) and space complexity O(1)
