// Problem: M Coloring Problem
// URL: https://takeuforward.org/plus/dsa/problems/m-coloring-problem?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-19

class Solution {

    boolean isSafe(int node, int color, int[] colors, int[][] graph, int n) {
        for (int k = 0; k < graph.length; k++) {
            int u = graph[k][0];
            int v = graph[k][1];

            if (u == node && colors[v] == color)
                return false;
            if (v == node && colors[u] == color)
                return false;
        }
        return true;
    }

    boolean solve(int node, int[] colors, int m, int n, int[][] graph) {
        if (node == n)
            return true;

        for (int color = 1; color <= m; color++) {
            if (isSafe(node, color, colors, graph, n)) {
                colors[node] = color;

                if (solve(node + 1, colors, m, n, graph))
                    return true;

                colors[node] = 0;
            }
        }
        return false;
    }

    boolean graphColoring(int[][] edges, int m, int n) {
        int[] colors = new int[n];
        return solve(0, colors, m, n, edges);
    }
}

// @formatter:off
// Brute force approach
// Generate all possible colorings of the graph and check if any of them is valid
// For each node, we have m choices of colors, so we have m^n possible colorings
// Check if each coloring is valid by checking the edges of the graph
// If any edge has the same color on both ends, the coloring is not valid
// If we find a valid coloring, return true, otherwise return false after checking all colorings


// Optimal approach
// Use backtracking to assign colors to the nodes of the graph
// Check if the current coloring is valid, if not backtrack and try a different color
// Time complexity O(m^n) and space complexity O(n)