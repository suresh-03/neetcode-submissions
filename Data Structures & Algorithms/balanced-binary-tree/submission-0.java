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
    public boolean isBalancedTree = true;
    public boolean isBalanced(TreeNode root) {
        calculateHeight(root);
        return isBalancedTree;
    }

    public int calculateHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = calculateHeight(root.left) + 1;
        int rightHeight = calculateHeight(root.right) + 1;

        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalancedTree = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
