// Problem: Sudoku Solver
// URL: https://takeuforward.org/plus/dsa/problems/sudoko-solver?source=strivers-sde-sheet
// Difficulty: Hard
// Date Solved: 2026-06-18

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        // Check row
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // Check 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}

// Brute force approach
// Use backtracking to fill the board, for each empty cell, try all possible
// numbers and check if it's safe to place the number in the cell, if it is,
// place the number and recursively call the function to fill the next cell,
// if the board is filled, return true, else backtrack and try the next number
// Time complexity O(9^(n*n)) and space complexity O(n*n) for the

// Optimal approach
// Use backtracking with optimizations, maintain three boolean arrays to keep
// track of the numbers already placed in the current row, column and 3x3 box,
// this way we can check if it's safe to place a number in O(1) time, Time
// complexity O(9^(n*n)) but with much less constant factor and space complexity
// O(n*n) for the board and O(n) for the boolean arrays.
