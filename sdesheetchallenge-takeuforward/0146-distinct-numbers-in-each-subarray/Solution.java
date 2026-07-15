// Problem: Distinct Numbers in Each Subarray
// URL: https://takeuforward.org/plus/dsa/problems/distinct-numbers-in-each-subarray?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-15

class Solution {
    public List<Integer> distinctNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                if (map.get(nums[i - k]) == 0) {
                    map.remove(nums[i - k]);
                }
            }

            if (i >= k - 1) {
                result.add(map.size());
            }
        }

        return result;
    }
}

// Brute force approach
// For each subarray of size k, use a set to count the distinct numbers.
// Time complexity O(n*k) and space complexity O(k)

// Optimal approach
// Use a sliding window of size k and a hashmap to count the frequency of each
// number in the current window. As we slide the window, we update the hashmap
// by adding the new number and removing the old number. The size of the hashmap
// will give us the count of distinct numbers in the current window.
// Time complexity O(n) and space complexity O(k)