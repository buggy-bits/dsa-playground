// Problem: 4 Sum
// URL: https://takeuforward.org/plus/dsa/problems/4-sum?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-07

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> li = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return li;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        li.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + -1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return li;
    }
}

// Brute force approach
// Use 4 nested loops to iterate through the array and find all combinations of
// 4 numbers that sum up to the target
// Time complexity O(n^4) and space complexity O(1)

// Optimal approach
// Sort the array and use 2 nested loops to fix the first 2 numbers, then use 2
// pointers to find the remaining 2 numbers that sum up to the target
// Handle duplicates by skipping over them in the loops and while moving the
// pointers
// Time complexity O(n^3) and space complexity O(1)
