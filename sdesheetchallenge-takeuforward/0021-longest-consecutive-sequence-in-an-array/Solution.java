// Problem: Longest Consecutive Sequence in an Array
// URL: https://takeuforward.org/plus/dsa/problems/longest-consecutive-sequence-in-an-array?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-07

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        for (int it : st) {
            if (!st.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                while (st.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}

// Brute force approach
// Sort the array and iterate through it to find longest consecutive sequence
// Time complexity O(n log n) and space complexity O(1)

// Optimal approach
// Use a HashSet to store the elements of the array, then iterate through the
// HashSet and for each element, check if it is the start of a sequence (i.e. it
// does not have a predecessor in the set), if it is, then keep checking for the
// next elements in the sequence and count the length of the sequence, update
// the longest length found so far
// Time complexity O(n) and space complexity O(n)

// Another approach is to use a HashMap to store the length of the longest
// sequence for each element, then iterate through the array and for each
// element, check if it is the
// start of a sequence, then keep checking for the next elements in the sequence
// and update the
// length of the sequence for each element in the sequence, update the longest
// length found so far
// Time complexity O(n) and space complexity O(n)