/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
        return null;
        if(head.next==null)
        return head;
        int c=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            c++;
        }
        k=k%c;
        if(k==0)return head;

        int p=c-k;
        int i=0;
        ListNode t=head;
        ListNode N=new ListNode();
         while(i<p-1){
            t=t.next;
            i++;
        }
        ListNode newHead = t.next; 
        t.next=null;
        temp.next=head;
        head=newHead;
        return head;
    }
}