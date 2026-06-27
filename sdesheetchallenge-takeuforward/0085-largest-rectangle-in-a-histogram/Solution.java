// Problem: Largest rectangle in a histogram
// URL: https://takeuforward.org/plus/dsa/problems/largest-rectangle-in-a-histogram?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-27

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

// Approach
// Use a stack to keep track of the indices of the bars in the histogram.
// Iterate through the heights array and for each bar, pop from the stack until
// the current bar is taller than the bar at the index stored at the top of the
// stack. For each popped bar, calculate the area of the rectangle that can be
// formed with that bar as the shortest bar. Update the maximum area found so
// far. Finally, return the maximum area.
// Time complexity O(n) and space complexity O(n)