// Problem: Number of Recent Calls
// URL: https://leetcode.com/problems/number-of-recent-calls/
// Difficulty: Easy
// Date Solved: 2026-04-15

// Can do it in another way using pointers. but this is fast and easy to understand.

class Solution {
    Queue<Integer> myQ;

    public RecentCounter() {
        myQ = new LinkedList<>();
        
    }

    public int ping(int t) {
        myQ.add(t);
        while (myQ.peek() < t - 3000) {
            myQ.poll();
        }
        return myQ.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
