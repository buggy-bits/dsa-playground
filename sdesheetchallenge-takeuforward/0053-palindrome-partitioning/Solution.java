// Problem: Palindrome partitioning
// URL: https://takeuforward.org/plus/dsa/problems/palindrome-partitioning?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-17

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, res);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(s, end, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Brute force approach
// Generate all possible partitions of the string and check if each partition is
// a palindrome
// Time complexity O(n * 2^n) and space complexity O(n)

// Optimal approach
// Use backtracking to generate partitions and check for palindromes on the fly
// Time complexity O(n * 2^n) and space complexity O(n)