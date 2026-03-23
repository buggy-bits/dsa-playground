// Problem: Unique Number of Occurrences
// URL: https://leetcode.com/problems/unique-number-of-occurrences
// Difficulty: Easy
// Date Solved: 2026-03-23

import java.util.HashMap;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (Integer x : arr) {
            if (myMap.containsKey(x)) {
                myMap.replace(x, myMap.get(x) + 1);
            } else {
                myMap.put(x, 1);
            }
        }
        int[] freq = new int[1000 + 1];
        for (int a : myMap.values()) {
            if (freq[a] > 0) {
                return false;
            } else {
                freq[a] += 1;
            }
        }
        return true;
    }
}
