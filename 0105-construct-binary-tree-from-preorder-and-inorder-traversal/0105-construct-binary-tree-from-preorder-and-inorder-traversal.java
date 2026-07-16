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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
        return null;
        int index=0;
        int init=preorder[0];
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==init)
            index=i+1;
        }
        TreeNode node = new TreeNode(init);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,index),Arrays.copyOfRange(inorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(preorder,index,preorder.length),Arrays.copyOfRange(inorder,index,inorder.length));
        return node;
    }
}//this is not the most optimal soln the most optimal solution will be using hashmap