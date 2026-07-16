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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)
        return null;
        int index=0;
        int l=postorder.length;
        int init=postorder[l-1];
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==init)
            index=i;
        }
        TreeNode node = new TreeNode(init);
        node.left=buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(inorder,index+1,l),Arrays.copyOfRange(postorder,index,inorder.length-1));
        return node;
    }
}