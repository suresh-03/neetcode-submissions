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
    public int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return diameter;
    }

    public int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = root.left == null ? 0 : findDiameter(root.left) + 1;
        int right = root.right == null ? 0 : findDiameter(root.right) + 1;
        diameter = Math.max(diameter,left + right);
        return Math.max(left, right);

    }
}
