// Problem: Merge Overlapping Subintervals
// URL: https://takeuforward.org/plus/dsa/problems/merge-overlapping-subintervals?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-03

// Time complexity O(n + m), Space complexity O(m) 
// n = no of intervals, m = maximum end time of intervals
class Solution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        int max = 0;
        for (int i = 0; i < intervals.size(); i++) {
            max = Math.max(intervals.get(i).get(0), max);
        }

        int[] mp = new int[max + 1];
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);
            mp[start] = Math.max(end + 1, mp[start]);
        }

        List<List<Integer>> res = new ArrayList<>();

        int have = -1;
        int intervalStart = -1;

        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i;
                }
                have = Math.max(mp[i] - 1, have);
            }

            if (have == i) {
                res.add(Arrays.asList(intervalStart, have));
                have = -1;
                intervalStart = -1;
            }
        }

        if (intervalStart != -1) {
            res.add(Arrays.asList(intervalStart, have));
        }

        return res;
    }
}

// Brute force approach
// Sort the intervals based on the start time,
// iterate through the sorted intervals and merge them if they overlap,
// Time complexity O(nlogn) and space complexity O(n)

// Optimal approach
// Find the maximum end time of the intervals, create a map of size max + 1
// Iterate through the intervals and mark the end time in the map, then iterate
// through the map and find the intervals, if we find a non zero value, it means
// we have an interval, keep track of the start and end time and add it to the
// result list, Time complexity O(n + m) where m is the maximum end time and
// space
// complexity O(m) where m is the maximum end time

// Another approach is to use a priority queue,
// add the intervals to the priority queue based on the start time, then iterate
// through the priority queue and merge the intervals if they overlap,
// Time complexity O(nlogn) and space complexity O(n