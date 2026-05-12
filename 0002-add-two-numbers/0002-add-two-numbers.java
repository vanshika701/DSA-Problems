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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=l1;
        ListNode head2=l2;
        int sum = 0;
        int carry = 0;
        // if(head1==null)
        // return l2;
        // else 
        // if(head2==null)
        // return l1;
        // else
        // if(head1==null&&head2==null)
        // return null;
        ListNode dummy=new ListNode();
        ListNode list=dummy;
        while(head1!=null||head2!=null||carry!=0){
            int x = (head1 != null) ? head1.val : 0;
int y = (head2 != null) ? head2.val : 0;

sum = x + y + carry;
            carry=sum/10;
            list.next=new ListNode(sum%10);
            list=list.next;
            if(head1!=null)
            head1=head1.next;
            if(head2!=null)
            head2=head2.next;
        }
        return dummy.next;
    }
}