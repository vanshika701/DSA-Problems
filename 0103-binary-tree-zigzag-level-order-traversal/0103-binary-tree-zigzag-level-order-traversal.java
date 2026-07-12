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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
        return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int l=0;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr=queue.poll();
                level.add(curr.val);
                if(curr.left!=null)
                queue.add(curr.left);
                if(curr.right!=null)
                queue.add(curr.right);
            }
            l++;
            if(l%2==0)
            Collections.reverse(level);
        result.add(level);
        }
        return result;
    }
}