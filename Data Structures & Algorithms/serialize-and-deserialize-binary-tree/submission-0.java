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

public class Codec {

    // Encodes a tree to a single string.
    int index = 0;
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root, str);
        return str.toString();
    }

    public void serialize(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null ");
            return;
        }

        str.append(root.val+" ");
        serialize(root.left,str);
        serialize(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.trim().split(" ");
        return deserialize(nodes);
    }

    public TreeNode deserialize(String[] nodes){
        if(index >= nodes.length){
            return null;
        }

        TreeNode root = nodes[index].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        if(root != null){
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
        }

        return root;
    }
}
