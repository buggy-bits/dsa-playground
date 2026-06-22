// Problem: K-th Largest element in an array
// URL: https://takeuforward.org/plus/dsa/problems/k-th-largest-element-in-an-array?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-22

class Solution {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

// brute force approach
// Sort the array and return the k-1 th element from the end of the array
// Time complexity O(n log n) and space complexity O(1)

// optimal approach
// Use a min heap of size k to keep track of the k largest elements in the array
// Iterate through the array and add each element to the min heap, if the size
// of the min heap exceeds k, remove the smallest element from the min heap
// After iterating through the array, the top element of the min heap will be
// the k-th largest element in the array
// Time complexity O(n log k) and space complexity O(k)