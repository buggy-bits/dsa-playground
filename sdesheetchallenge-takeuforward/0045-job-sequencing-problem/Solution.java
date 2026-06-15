// Problem: Job sequencing Problem
// URL: https://takeuforward.org/plus/dsa/problems/job-sequencing-problem?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-15

class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        // Sort in descending order based on profit
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Find maximum deadline
        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        // Slot array to track free time slots
        boolean[] slot = new boolean[maxDeadline + 1];

        int countJobs = 0;
        int maxProfit = 0;

        // Try to schedule each job
        for (int[] job : Jobs) {
            int deadline = job[1];
            int profit = job[2];

            // Find a free slot from deadline backwards
            for (int t = Math.min(maxDeadline, deadline); t > 0; t--) {
                if (!slot[t]) {
                    slot[t] = true;
                    countJobs++;
                    maxProfit += profit;
                    break;
                }
            }
        }

        return new int[] { countJobs, maxProfit };
    }
}

// Brute force approach
// Generate all possible combinations of jobs and check which combination
// gives the maximum profit while satisfying the deadlines
// Time complexity O(n * 2^n) and space complexity O(n)

// @formatter:off
// Optimal approach
// Sort the jobs in descending order of profit
// Iterate through the jobs and for each job, find a free slot from its deadline backwards
// If a free slot is found, schedule the job and update the count of jobs and total profit
// Time complexity O(n log n) for sorting and O(n * d) for scheduling where d is the maximum deadline