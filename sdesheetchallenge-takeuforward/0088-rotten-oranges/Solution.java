// Problem: Rotten Oranges
// URL: https://takeuforward.org/plus/dsa/problems/rotten-oranges?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-27

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Add all rotten oranges to the queue and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0)
            return 0;

        int minutes = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[] { nr, nc });
                        rotted = true;
                    }
                }
            }

            if (rotted)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}

// Brute force approach
// Use a nested loop to check for each fresh orange if it can be rotted by any
// rotten orange
// Time complexity O(n^2) and space complexity O(1)

// @formatter:off
// Optimal approach
// Use BFS to rot the fresh oranges level by level
// Add all rotten oranges to the queue and count fresh ones
// For each rotten orange, rot its adjacent fresh oranges and add them to the queue
// Keep track of the minutes taken to rot all fresh oranges
// If there are still fresh oranges left, return -1
// Time complexity O(n) and space complexity O(n)
