// Problem: Successful Pairs of Spells and Potions
// URL: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
// Difficulty: Medium
// Date Solved: 2026-04-26

import java.util.Arrays;

// Can be done in other approaches as well, but this is the most efficient one (balancing time and space constrains). 
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;

        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = m;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if ((long) potions[mid] * spells[i] >= success) {
                    right = mid; // try to find smaller index
                } else {
                    left = mid + 1;
                }
            }

            spells[i] = m - left;
        }
        return spells;

    }

}
