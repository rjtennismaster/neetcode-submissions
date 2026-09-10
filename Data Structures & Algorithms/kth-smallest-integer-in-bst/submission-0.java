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
    public int kthSmallest(TreeNode root, int k) {
        // keep a tuple of [k(count), result]
        int[] count = new int[2];
        count[0] = k;
        dfs(root, count);
        return count[1];
    }

    private void dfs(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }

        // do inorder traversal
        dfs(root.left, count);

        // at this node, stop if count is 0.
        if (count[0] == 0) {
            return;
        }

        count[0]--;

        if (count[0] == 0) {
            // record the value
            count[1] = root.val;
            return;
        }

        dfs(root.right, count);
    }
}
