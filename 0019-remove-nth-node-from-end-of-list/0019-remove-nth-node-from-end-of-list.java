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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int i=1;
        while(temp.next!=null){
            temp=temp.next;
            i++;
        }
        if(i==n)
        return head.next;
        int k=1;
        temp=head;
        while(k!=(i-n)){
           temp=temp.next;
           k++;
        }
        temp.next=temp.next.next;
        return head;
    }
}