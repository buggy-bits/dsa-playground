// Problem: Kids With the Greatest Number of Candies
// URL: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
// Difficulty: Easy
// Date Solved: 2026-03-23

import java.util.ArrayList;
import java.util.List;

// minimize the use of finding length by candies.length
// also find max in one pass, no need to use Math.max()
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> ans = new ArrayList<>(candies.length);
        int maxCandies = 0;

        for (int x : candies) {
            if (maxCandies <= x) {
                maxCandies = x;
            }
        }

        for (int amount : candies) {
            ans.add((amount + extraCandies) >= maxCandies);
        }
        return ans;
    }
}
