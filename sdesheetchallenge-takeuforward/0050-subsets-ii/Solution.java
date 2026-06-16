// Problem: Subsets II
// URL: https://takeuforward.org/plus/dsa/problems/subsets-ii?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-16

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}

// Brute force
// Use a recursive approach to generate all possible subsets and add them to a
// set to avoid duplicates
// Time complexity O(2^n) and space complexity O(2^n)

// Optimal approach
// Sort the input array to handle duplicates easily
// Use a backtracking approach to generate subsets, and skip duplicates by
// checking if the current element is the same as the previous one
// Time complexity O(2^n) and space complexity O(2^n)