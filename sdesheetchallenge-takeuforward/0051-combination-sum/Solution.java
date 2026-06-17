// Problem: Combination Sum
// URL: https://takeuforward.org/plus/dsa/problems/combination-sum?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-17

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int startIndex, List<Integer> currentCombination,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}

// Approach
// Use backtracking to find all combinations of candidates that sum up to target
// Time complexity O(2^n) and space complexity O(n)
