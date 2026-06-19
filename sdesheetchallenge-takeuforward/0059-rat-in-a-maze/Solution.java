// Problem: Rat in a Maze
// URL:
// https://takeuforward.org/plus/dsa/problems/rat-in-a-maze?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-19

class Solution {

    private void solve(int i, int j, int[][] grid, int n,
            boolean[][] vis, String path,
            List<String> ans) {

        if (i == n - 1 && j == n - 1) {
            ans.add(path);
            return;
        }

        vis[i][j] = true;

        // Down
        if (i + 1 < n && !vis[i + 1][j] && grid[i + 1][j] == 1) {
            solve(i + 1, j, grid, n, vis, path + "D", ans);
        }

        // Left
        if (j - 1 >= 0 && !vis[i][j - 1] && grid[i][j - 1] == 1) {
            solve(i, j - 1, grid, n, vis, path + "L", ans);
        }

        // Right
        if (j + 1 < n && !vis[i][j + 1] && grid[i][j + 1] == 1) {
            solve(i, j + 1, grid, n, vis, path + "R", ans);
        }

        // Up
        if (i - 1 >= 0 && !vis[i - 1][j] && grid[i - 1][j] == 1) {
            solve(i - 1, j, grid, n, vis, path + "U", ans);
        }

        vis[i][j] = false; // backtrack
    }

    public List<String> findPath(int[][] grid) {
        List<String> ans = new ArrayList<>();
        int n = grid.length;

        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] vis = new boolean[n][n];
        solve(0, 0, grid, n, vis, "", ans);

        return ans;
    }
}

//@formatter:off
// Brute force approach
// Generate all possible paths from the top left corner to the bottom right corner and check if each path is valid/
// Time complexity O(4^(n*n)) and space complexity O(n*n) for the visited array



// Optimal approach
// Use backtracking to explore all possible paths from the top left corner to the bottom right corner
// Time complexity O(4^(n*n)) and space complexity O(n*n) for the visited array