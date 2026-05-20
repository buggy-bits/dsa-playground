// Problem: Number of Provinces
// URL: https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2
// Difficulty: Medium
// Date Solved: 2026-05-20

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        int count = 0;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int start, int[][] isConnected, int[] visited) {
        visited[start] = 1;
        for (int j = 0; j < isConnected[0].length; j++) {
            if (isConnected[start][j] == 1 && visited[j] != 1) {
                dfs(j, isConnected, visited);
            }
        }
    }
}
