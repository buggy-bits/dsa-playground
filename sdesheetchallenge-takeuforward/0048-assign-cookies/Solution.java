// Problem: Assign Cookies
// URL: https://takeuforward.org/plus/dsa/problems/assign-cookies?source=strivers-sde-sheet
// Difficulty: Easy
// Date Solved: 2026-06-16

class Solution {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int studentIndex = 0;
        int cookieIndex = 0;
        int count = 0;

        while (studentIndex < Student.length && cookieIndex < Cookie.length) {
            if (Student[studentIndex] <= Cookie[cookieIndex]) {
                count++;
                studentIndex++;
                cookieIndex++;
            } else {
                cookieIndex++;
            }
        }
        return count;
    }
}

// @formatter:off

// Brute force
// For each student, check if there is a cookie that can satisfy their greed factor
// Time complexity O(n*m) and space complexity O(1)


// Optimal approach
// Sort both the student and cookie arrays
// Use two pointers to iterate through both arrays, if the current cookie can satisfy the current student
// increment the count and move both pointers, otherwise move the cookie pointer to find a bigger cookie
// Time complexity O(n log n + m log m) and space complexity O(1)