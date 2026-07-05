// Problem: Vertical Order Traversal
// URL: https://takeuforward.org/plus/dsa/problems/vertical-order-traversal?source=strivers-sde-sheet
// Difficulty: Medium
// Date Solved: 2026-07-06

class Solution {

    class NodeInfo {
        int row, col, val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    List<NodeInfo> nodes = new ArrayList<>();

    private void dfs(TreeNode root, int row, int col) {
        if (root == null)
            return;

        nodes.add(new NodeInfo(row, col, root.data));

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        // Sort by col, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;
            if (a.row != b.row)
                return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;
        List<Integer> colList = null;

        for (NodeInfo node : nodes) {
            if (node.col != prevCol) {
                colList = new ArrayList<>();
                result.add(colList);
                prevCol = node.col;
            }
            colList.add(node.val);
        }

        return result;
    }
}

// @formatter:off
// Approach
// Use DFS to traverse the tree and store the row, col, and value of each node
// Sort the nodes based on col, then row, then value
// Group the nodes by column and return the result  
// Time complexity O(n log n) due to sorting and space complexity O(n) for storing nodes
