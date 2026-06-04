// Problem: Inversion of Array
// URL: https://takeuforward.org/plus/dsa/problems/count-inversions?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-04

class Solution {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;

        if (low >= high)
            return count;

        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    public int merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }
}

// Brute force
// Iterate through the array and count the number of pairs (i, j) such that i <
// j and arr[i] > arr[j]
// Time complexity O(n^2) and space complexity O(1)

// Optimal approach
// Use merge sort to count the inversions while sorting the array
// Time complexity O(n log n) and space complexity O(n)