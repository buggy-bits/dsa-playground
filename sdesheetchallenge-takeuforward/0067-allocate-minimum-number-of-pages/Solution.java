// Problem: Allocate Minimum Number of Pages
// URL: https://takeuforward.org/plus/dsa/problems/book-allocation-problem?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-21

class Solution {
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // If more students than books, impossible
        if (m > n)
            return -1;

        // Binary search range: [max(pages), sum(all pages)]
        int low = 0, high = 0;
        for (int page : nums) {
            low = Math.max(low, page); // at least the biggest book
            high += page; // all books to one student
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, n, mid, m)) {
                result = mid; // this max is possible, try smaller
                high = mid - 1;
            } else {
                low = mid + 1; // not possible, need larger max
            }
        }

        return result;
    }

    // Check if we can allocate books with max 'pages' per student
    private boolean isPossible(int[] nums, int n, int pages, int m) {
        int students = 1;
        int currentPages = 0;

        for (int i = 0; i < n; i++) {
            if (currentPages + nums[i] <= pages) {
                currentPages += nums[i];
            } else {
                students++;
                currentPages = nums[i];
            }
        }

        return students <= m;
    }
}

// Brute force approach
// Try all possible ways to allocate books and find the minimum of the maximum
// pages
// Time complexity O(2^n) and space complexity O(n)

// Optimal approach
// Use binary search to find the minimum of the maximum pages
// Check if a given maximum pages allocation is possible with the given number
// of students, if not possible, increase the maximum pages,
// if possible, decrease the maximum pages

// Time complexity O(n log(sum of pages)) and space complexity O(1)