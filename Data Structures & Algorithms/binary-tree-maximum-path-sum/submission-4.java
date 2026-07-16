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
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int value = root.val;
        value = Math.max(root.val + left, value);
        value = Math.max(root.val + right, value);

        maxSum = Math.max(maxSum, value);
        maxSum = Math.max(maxSum,root.val + left + right);

        return value;
    }
}
