// Problem: Can Place Flowers
// URL: https://leetcode.com/problems/can-place-flowers/
// Difficulty: Easy
// Date Solved: 2026-03-23

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        // only iterate if there are any plants to place and i < size
        for (int i = 0; i < size && n > 0; i++) {
            boolean prev = (i == 0) || flowerbed[i - 1] == 0; // to check the previous position
            boolean future = (i == size - 1) || flowerbed[i + 1] == 0; // to check next position

            if (prev && future && flowerbed[i] == 0) { // only if the place is eligible
                flowerbed[i] = 1; // plant a plant
                n--;
            }
        }
        // only return true if all plants are planted, else return false
        return (n <= 0);
    }
}