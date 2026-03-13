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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
        return head;
        int count = 0;
        ListNode temp = head;
        while(temp != null && count <k){
            temp = temp.next;
            count++;}
        if(count < k) return head;
        int p=0;
            ListNode prev=null;
            ListNode pres=head;
            ListNode next=head.next;
        while(p<k){
            next=pres.next;
            pres.next=prev;
            prev=pres;
            pres=next;
            p++;
        }
        head.next = reverseKGroup(pres , k);
        p=0;
        return prev;
    }
}