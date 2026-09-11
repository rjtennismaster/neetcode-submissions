/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int initialDepth = 1;
        return dfs(root, initialDepth);
    }

    private int dfs(TreeNode node, int currDepth) {
        if (node == null) {
            return currDepth - 1;
        }

        int rDepth = dfs(node.right, currDepth + 1);
        int lDepth = dfs(node.left, currDepth + 1);

        return Math.max(rDepth, lDepth);
    }
}
