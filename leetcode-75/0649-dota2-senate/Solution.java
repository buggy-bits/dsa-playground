// Problem: Dota2 Senate
// URL: https://leetcode.com/problems/dota2-senate/
// Difficulty: Medium
// Date Solved: 2026-05-30

class Solution {
    public String predictPartyVictory(String senate) {
        char[] arre = senate.toCharArray();
        int n = arre.length;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arre[i] == 'R') {
                rQ.offer(i);
            } else {
                dQ.offer(i);
            }
        }

        while (!dQ.isEmpty() && !rQ.isEmpty()) {
            int rTurn = rQ.poll();
            int dTurn = dQ.poll();

            if (rTurn < dTurn) {
                rQ.add(rTurn + n);
            } else {
                dQ.add(dTurn + n);

            }
        }

        return rQ.isEmpty() ? "Dire" : "Radiant";
    }
}

// The problem statement is wantedly confusing and long,
// The main aim of each senator is to ban the other party's senator
// Do not think of voting, in the end its just about banning opponent's
// senators, and the one who has more senators left in the end wins.