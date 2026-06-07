// Problem: Two Sum
// URL: https://takeuforward.org/plus/dsa/problems/two-sum?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-07

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (myMap.containsKey(nums[i])) {
                return new int[] { i, myMap.get(nums[i]) };
            }
            int t = target - nums[i];
            myMap.put(t, i);

        }
        return new int[] { 0, 0 };
    }
}

// Brute force approach
// Use 2 nested loops to check for each pair of elements if they sum up to the
// target
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a HashMap to store the complement of each element (target - current
// element) and
// check if the current element is in the HashMap, if yes , we have found it
// Time complexity O(n) and space complexity O(n)

// Another approach
// sort the array and use 2 pointers to find the pair that sums up to the target
// Time complexity O(n log n) and space complexity O(1)