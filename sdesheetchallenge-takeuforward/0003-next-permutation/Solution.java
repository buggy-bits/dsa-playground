// Problem: Next Permutation
// URL: https://takeuforward.org/plus/dsa/problems/next-permutation?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-01

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int p = -1;
        // some extra check for 1 and 2 length array
        if (n == 1) {
            return;
        }

        if (n == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        for (int i = (n - 1) - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        // as p is unchanged, array is in decending order
        // make it ascending and return, (reverse the array)
        if (p == -1) {
            reverseArre(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;

                break;

            }
        }

        reverseArre(nums, p + 1, n - 1);

    }

    private void reverseArre(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];

            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

}

// @formatter:off
// Brute force approach is to generate all the permutations (time taking process))
// Find the current permutation and return the next one,
// Time complexity O(n * n!) and space complexity O(n)

// The optimal approach is kinda tricky come up with
// Start from the right and find a pivot point where the order is disturbed
// If there is no such point, it means the array is in descending order, reverse it and return
// If there is a pivot point, find the rightmost element which is greater than the pivot point
// swap these 2 elements, to make the right side in decending order
// now reverse the right side part of pivot index to get the next permutation
