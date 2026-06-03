// Problem: Merge two sorted arrays without extra space
// URL:
// https://takeuforward.org/plus/dsa/problems/merge-two-sorted-arrays-without-extra-space?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-03

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;

        int pointer = m + n - 1;

        while (b >= 0) {
            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[pointer] = nums1[a];
                a--;

            } else {
                nums1[pointer] = nums2[b];
                b--;
            }
            pointer--;
        }

    }
}