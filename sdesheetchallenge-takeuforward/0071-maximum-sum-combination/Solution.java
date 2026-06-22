// Problem: Maximum Sum Combination
// URL: https://takeuforward.org/plus/dsa/problems/maximum-sum-combination?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-22

class Solution {
    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        HashSet<String> visited = new HashSet<>();

        maxHeap.offer(new Node(
                nums1[n - 1] + nums2[n - 1],
                n - 1,
                n - 1));
        visited.add((n - 1) + "#" + (n - 1));

        int[] result = new int[k];
        int idx = 0;

        while (idx < k && !maxHeap.isEmpty()) {
            Node curr = maxHeap.poll();
            result[idx++] = curr.sum;

            int i = curr.i;
            int j = curr.j;

            if (i - 1 >= 0) {
                String key = (i - 1) + "#" + j;
                if (!visited.contains(key)) {
                    maxHeap.offer(new Node(
                            nums1[i - 1] + nums2[j],
                            i - 1,
                            j));
                    visited.add(key);
                }
            }

            if (j - 1 >= 0) {
                String key = i + "#" + (j - 1);
                if (!visited.contains(key)) {
                    maxHeap.offer(new Node(
                            nums1[i] + nums2[j - 1],
                            i,
                            j - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }
}

// Brute force approach
// Generate all possible sums of pairs from nums1 and nums2, sort them and
// return the top k sums
// Time complexity O(n^2 log(n^2)) and space complexity O(n^2

// Optimal approach
// Use a max heap to keep track of the largest sums, start with the largest
// possible sum (nums1[n-1] + nums2[n-1]) and then explore the next possible
// sums by decrementing the indices of nums1 and nums2, use a HashSet to
// avoid processing the same pair of indices more than once
// Time complexity O(k log k) and space complexity O(k)