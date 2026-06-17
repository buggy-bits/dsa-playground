// Problem: Combination Sum II
// URL: https://takeuforward.org/plus/dsa/problems/combination-sum-ii?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-17

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int startIndex, List<Integer> currentCombination,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}

// Approach
// Use backtracking to find all unique combinations of candidates
// that sum up to target
// Sort the candidates array to handle duplicates
// Time complexity O(2^n) and space complexity O(n)
