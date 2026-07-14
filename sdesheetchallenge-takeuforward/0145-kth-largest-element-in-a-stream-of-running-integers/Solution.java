// Problem: Kth largest element in a stream of running integers
// URL: https://takeuforward.org/plus/dsa/problems/kth-largest-element-in-a-stream-of-running-integers?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-07-14

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}

// Approach
// Use a min heap of size k to keep track of the k largest elements in the
// stream
// For each new element added to the stream, add it to the min heap, if the size
// of the min heap exceeds k, remove the smallest element from the min heap
// After adding the new element, the top element of the min heap will be the
// k-th largest element in the stream
// Time complexity O(log k) for each insertion
// space complexity O(k) for storing the k largest elements in the min heap.
