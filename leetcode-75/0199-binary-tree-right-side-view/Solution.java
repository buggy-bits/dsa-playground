// Problem: Binary Tree Right Side View
// URL: https://leetcode.com/problems/binary-tree-right-side-view
// Difficulty: Medium
// Date Solved: 2026-03-30

public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, 0, result);
    return result;
}

void dfs(TreeNode node, int level, List<Integer> result) {
    if (node == null)
        return;

    // first node seen at this level
    if (level == result.size()) {
        result.add(node.val);
    }

    dfs(node.right, level + 1, result);
    dfs(node.left, level + 1, result);
}