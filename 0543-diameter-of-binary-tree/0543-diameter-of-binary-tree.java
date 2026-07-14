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
        int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    public int height(TreeNode node){
        if(node==null)
        return 0;
        int lefth=height(node.left);
        int righth=height(node.right);
        int dia=lefth+righth;
        diameter=Math.max(dia, diameter);
        return Math.max(lefth,righth)+1;
    }
}