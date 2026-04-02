// Problem: Equal Row and Column Pairs
// URL: https://leetcode.com/problems/equal-row-and-column-pairs/
// Difficulty: Medium
// Date Solved: 2026-04-02

class Solution {
    // can do it with StringBuilder for better result.
    // create a unique key for each row, do the same with each col,
    // then check matching strings
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        HashMap<String, Integer> myMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String r = Arrays.toString(grid[i]);
            myMap.put(r, myMap.getOrDefault(r, 0) + 1);

        }

        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            String c = Arrays.toString(col);

            if (myMap.containsKey(c)) {
                ans += myMap.get(c);
            }
        }
        return ans;
    }
}
