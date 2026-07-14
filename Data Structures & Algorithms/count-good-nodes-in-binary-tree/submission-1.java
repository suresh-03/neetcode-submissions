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
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root,Integer.MIN_VALUE);
    }

    public int findGoodNodes(TreeNode root, int max){
        if(root == null){
            return 0;
        }

        int left = findGoodNodes(root.left, Math.max(max, root.val));
        int right = findGoodNodes(root.right, Math.max(max, root.val));

        
        return root.val >= max ? 1 + left + right : left + right;
    }
}
