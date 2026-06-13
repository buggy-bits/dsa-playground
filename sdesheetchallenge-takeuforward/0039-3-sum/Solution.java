// Problem: 3 Sum
// URL: https://takeuforward.org/plus/dsa/problems/3-sum?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-13

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}

// Brute force approach
// Use three nested loops to find all triplets and check if their sum is zero,
// if yes, add the triplet to the result list
// Time complexity O(n^3) and space complexity O(1)

// Optimal approach
// Sort the array
// use two pointers to find pairs that sum up to -nums[i]
// Iterate through the array
// for each element, use two pointers to find pairs that sum up to -nums[i],
// if the sum is zero, add the triplet to the result list,
// if the sum is less than zero, move the left pointer to right,
// if the sum is greater than zero, move the right pointer to left,
// continue the same till left pointer is less than right pointer,
// also skip duplicates to avoid duplicate triplets in the result list
// Time complexity O(n^2) and space complexity O(1) (excluding space for result)
