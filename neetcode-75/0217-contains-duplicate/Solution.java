// Problem: Contains Duplicate
// URL: https://leetcode.com/problems/contains-duplicate/
// Difficulty: Easy
// Date Solved: 2026-05-30

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> mySet = new HashSet<>();
        for (Integer i : nums) {
            if (mySet.contains(i)) {
                return true;
            }
            mySet.add(i);
        }
        return false;
    }
}

// can use a HashSet and check for existance of each element, (Best out of all)
// can also sort the array and check for adjacent elements,
// can use a Hashmap and check for the frequency of each element,
// can also use a boolean array of size 10^5 + 1 and check for existance.
