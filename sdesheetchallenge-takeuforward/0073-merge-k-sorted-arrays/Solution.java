// Problem: Merge K Sorted Arrays
// URL: https://takeuforward.org/plus/dsa/problems/merge-k-sorted-arrays?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-23

class Solution {
    public List<Integer> mergeKSortedArrays(int[][] arr, int k) {
        if (k == 0)
            return new ArrayList<>();

        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrays.add(arr[i]);
        }

        while (arrays.size() > 1) {
            List<int[]> mergedArrays = new ArrayList<>();

            for (int i = 0; i < arrays.size(); i += 2) {
                if (i + 1 < arrays.size()) {
                    mergedArrays.add(merge(arrays.get(i), arrays.get(i + 1)));
                } else {
                    mergedArrays.add(arrays.get(i));
                }
            }

            arrays = mergedArrays;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : arrays.get(0)) {
            result.add(num);
        }

        return result;
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, idx = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[idx++] = a[i++];
            } else {
                res[idx++] = b[j++];
            }
        }

        while (i < a.length) {
            res[idx++] = a[i++];
        }

        while (j < b.length) {
            res[idx++] = b[j++];
        }

        return res;
    }
}

// @formatter:off
// Brute force approach
// Use a min heap to store the first element of each array, pop the smallest
// element and add the next element from the same array to the heap until all elements are processed
// Time complexity O(n log k) and space complexity O(k)


// Optimal approach
// Use divide and conquer approach, merge pairs of arrays until only one array is left
// Time complexity O(n log k) and space complexity O(n) (for the merged array