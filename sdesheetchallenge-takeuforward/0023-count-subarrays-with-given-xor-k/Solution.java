// Problem: Count subarrays with given xor K
// URL: https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-08

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        for (int num : nums) {
            prefixXor ^= num;
            int target = prefixXor ^ k;

            if (freq.containsKey(target)) {
                count += freq.get(target);
            }
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}

// Brute force approach
// Use 2 nested loops to find all subarrays and calculate their xor,
// if the xor is equal to k, increment the count
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use a HashMap to store the frequency of prefix xor values,
// Iterate through the array and calculate the prefix xor,
// for each prefix xor, calculate the target xor (prefixXor ^ k)
// and check if it is present in the HashMap, if yes,
// add the frequency of the target xor to the count,
// then update the frequency of the current prefix xor in the HashMap
// Time complexity O(n) and space complexity O(n)
