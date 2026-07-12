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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 1));
        int lastLevel = 1;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            Node n = q.poll();

            if(lastLevel == n.level){
                list.add(n.node.val);
            }
            else{
                ans.add(list);
                list = new ArrayList<>();
                list.add(n.node.val);
                lastLevel = n.level;
            }
           

            if(n.node.left != null) q.offer(new Node(n.node.left, n.level + 1));
            if(n.node.right != null) q.offer(new Node(n.node.right, n.level + 1));
        }

        ans.add(list);

        return ans;
    }
}

class Node{
    TreeNode node;
    int level;

    public Node(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
