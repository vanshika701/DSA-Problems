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
        /*first method(also correct and optimal)
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
        }*/
        Deque<TreeNode> dequeue=new LinkedList();
        dequeue.addFirst(root);
        int l=1;
        while(!dequeue.isEmpty()){
            int levelSize=dequeue.size();
            List<Integer> level=new ArrayList<>(levelSize);
            for(int i=0;i<levelSize;i++){
            if(l%2==1){
            TreeNode curr=dequeue.removeFirst();
            level.add(curr.val);
            if(curr.left!=null)
            dequeue.addLast(curr.left);
            if(curr.right!=null)
            dequeue.addLast(curr.right);
            }
            else
            if(l%2==0){
            TreeNode curr=dequeue.removeLast();
            level.add(curr.val);
            if(curr.right!=null)
            dequeue.addFirst(curr.right);
            if(curr.left!=null)
            dequeue.addFirst(curr.left);
            }
            }
            l++;
            result.add(level);
        }
        return result;
    }
}