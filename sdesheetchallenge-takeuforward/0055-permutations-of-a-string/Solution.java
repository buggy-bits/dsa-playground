// Problem: Permutations of a String
// URL: https://takeuforward.org/plus/dsa/problems/permutations-of-a-string?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-18

class Solution {
    public List<String> permuteUnique(String s) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        StringBuilder sb = new StringBuilder();
        backtrack(arr, used, sb, ans);
        return ans;

    }

    private void backtrack(char[] arr, boolean[] used, StringBuilder sb, List<String> ans) {
        if (sb.length() == arr.length) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sb.append(arr[i]);
            backtrack(arr, used, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}

// Brute force approach
// Use backtracking to generate all permutations of the string, and use a set to
// store unique permutations
// Time complexity O(n! * n) and space complexity O(n! * n)

// Optimal approach
// Sort the string and use backtracking to generate unique permutations by
// skipping over duplicate characters
// Time complexity O(n! * n) and space complexity O(n! * n)

// Another approach
// use a frequency map to store count of each character
// use backtracking to generate unique permutations by decrementing count
// of the character in the frequency map & skipping over characters with count 0
// Time complexity O(n! * n) and space complexity O(n! * n)