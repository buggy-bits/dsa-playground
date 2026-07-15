// Problem: Flood-fill Algorithm
// URL: https://takeuforward.org/plus/dsa/problems/flood-fill-algorithm?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-15

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image;
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}

// Approach
// Get the old color of the pixel at (sr, sc).
// If the old color is the same as the new color, return the image as is.
// use a depth-first search (DFS) to traverse the image starting from (sr,sc).
// For each pixel, if it is within bounds and has the old color, change it to
// the new color and recursively call DFS for its four neighbors (up, down,
// left, right).

// Time complexity: O(N), where N is the number of pixels in the image.
// Space complexity: O(N) for the recursion stack in the worst case.