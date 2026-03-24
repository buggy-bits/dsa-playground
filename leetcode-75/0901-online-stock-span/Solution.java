// Problem: Online Stock Span
// URL: https://leetcode.com/problems/online-stock-span
// Difficulty: Medium
// Date Solved: 2026-03-24

class StockSpanner {
    private Stack<int[]> myStack;

    public StockSpanner() {
        myStack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!myStack.isEmpty() && myStack.peek()[0] <= price) {
            span = span + myStack.pop()[1];

        }
        myStack.push(new int[] { price, span });

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
