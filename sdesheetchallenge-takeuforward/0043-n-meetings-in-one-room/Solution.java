// Problem: N meetings in one room
// URL: https://takeuforward.org/plus/dsa/problems/n-meetings-in-one-room?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-06-15

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1;
        int lastEnd = meetings[0][1];

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }
}

// @formatter:off
// Approach
// Create a 2D array to store the start and end times of the meetings.
// Sort the meetings based on their end times.
// Initialize a count variable to 1 (for the first meeting) and a lastEnd variable to the end time of the first meeting.
// Iterate through the sorted meetings starting from the second meeting.
// If the start time of the current meeting is greater than the lastEnd, increment the count and update lastEnd to the end time of the current meeting.
// Return the count of meetings that can be attended.

// Time complexity O(nlogn) and space complexity O(n)