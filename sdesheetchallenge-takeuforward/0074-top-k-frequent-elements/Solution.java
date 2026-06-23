// Problem: Top K Frequent Elements
// URL: https://takeuforward.org/plus/dsa/problems/top-k-frequent-elements?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-23

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> hm.get(a) - hm.get(b));
        for (int num : hm.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
// @formatter:off
// Brute force approach
// Use a HashMap to store the frequency of each element in the array,
// then sort the elements based on their frequency and return the top k elements
// Time complexity O(n log n) and space complexity O(n)


// Optimal approach
// Use a HashMap to store the frequency of each element in the array,
// then use a PriorityQueue (min heap) to keep track of the top k elements based
// on their frequency, iterate through the HashMap and add elements to the PriorityQueue,
// if the size of the PriorityQueue exceeds k, remove the element with the lowest frequency,
// Time complexity O(n log k) and space complexity O(n)