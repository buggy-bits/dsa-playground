// Problem: Majority Element-I
// URL: https://takeuforward.org/plus/dsa/problems/majority-element-i?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-05

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        int c = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                c++;
            }
        }

        if (c > n / 2) {
            return element;
        }

        return -1;
    }
}

// Brute force
// For each element, count the number of times it appears in the array
// if the count is greater than n/2, return that element
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use HashMap to count the frequency of each element
// return the element with frequency greater than n/2
// Time complexity O(n) and space complexity O(n)

// More optimal approach
// Use 2 variables, one to store the current element and another for count
// Iterate through the array, if count is 0, update the element and set count 1
// If current element is same as the element in array, increment count count
// Else decrement the count
// After the loop, the current element will be the majority element
// Check if the count is greater than n/2, and return element or -1
// Time complexity O(n) and space complexity O(1)