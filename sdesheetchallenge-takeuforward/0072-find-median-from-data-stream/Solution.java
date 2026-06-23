// Problem: Find Median from Data Stream
// URL: https://takeuforward.org/plus/dsa/problems/find-median-from-data-stream?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-23

class MedianFinder {

    private PriorityQueue<Integer> l = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> r = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (r.isEmpty() && l.isEmpty())
            l.offer(num);
        else if (r.isEmpty())
            if (l.peek() > num)
                l.offer(num);
            else
                r.offer(num);
        else if (r.peek() > num)
            l.offer(num);
        else
            r.offer(num);
        if (r.size() == l.size() + 2)
            l.offer(r.poll());
        if (r.size() + 2 == l.size())
            r.offer(l.poll());
    }

    public double findMedian() {
        if (l.size() == r.size())
            return (((double) r.peek() + l.peek()) / 2);

        return r.size() > l.size() ? (double) r.peek() : (double) l.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// approach
// Use two heaps, one max heap to store the smaller half of the numbers and
// one min heap to store the larger half of the numbers, the median will be the
// top of the max heap if the size of the max heap is greater than the size of
// the min heap, the median will be the top of the min heap if the size of the
// min heap is greater than the size of the max heap, if the size of both
// heaps is the same, the median will be the average of the top of both heaps
// Time complexity O(log n) for addNum and O(1) for findMedian, space complexity
// O(n) for storing the numbers in the heaps.
