// Problem: K-th largest element in an unsorted array.
// URL: https://takeuforward.org/plus/dsa/problems/k-th-largest-element-in-an-array?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-15

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

// Brute force approach
// Sort the array in descending order and return the k-th element.
// Time complexity O(n log n) and space complexity O(1)

// optimal approach
// Use a min heap of size k to keep track of k largest elements in array.
// Iterate through the array and add each element to the min heap.
// If the size of min heap exceeds k, remove the smallest element from the heap.
// After iterating through the entire array, the top of the min heap will be the
// k-th largest element in the array.
// Time complexity O(n log k) and space complexity O(k)
//
