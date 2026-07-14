// Problem: Find Median in a Stream
// URL: https://takeuforward.org/plus/dsa/problems/find-median-in-a-stream?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-14

class Solution {
    public List<Double> getMedian(int[] arr) {
        List<Double> ans = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                ans.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                ans.add((double) maxHeap.peek());
            }
        }

        return ans;
    }
}

// Approach
// Use two heaps, one max heap to store the smaller half of the numbers and
// one min heap to store the larger half of the numbers, the median will be the
// top of the max heap if the size of the max heap is greater than the size of
// the min heap, the median will be the top of the min heap if the size of the
// min heap is greater than the size of the max heap, if the size of both
// heaps is the same, the median will be the average of the top of both heaps
// Time complexity O(log n) for each insertion and O(1) for finding the median,
// space complexity O(n) for storing the numbers in the heaps.