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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            // don't add to the list
            return;
        }
        
        traverse(root.left, nodes);
        // if not null, add current node to list
        nodes.add(root.val);
        traverse(root.right, nodes);
    }
}