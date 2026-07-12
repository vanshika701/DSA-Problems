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
        List<List<Integer>> result=new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int levelSize=que.size();
            List<Integer> level=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
                TreeNode currNode=que.poll();
                level.add(currNode.val);
                if(currNode.left!=null)
                que.add(currNode.left);
                if(currNode.right!=null)
                que.add(currNode.right);
            }
        result.add(level);
        }
        return result;
    }
}