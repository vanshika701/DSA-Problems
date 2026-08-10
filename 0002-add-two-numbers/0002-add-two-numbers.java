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
        ListNode buffer=new ListNode(0);
        ListNode curr=buffer;
        int carry=0;
        while(l1!=null||l2!=null|| carry != 0){
            ListNode node=new ListNode();
            int x=(l1==null)?0:l1.val;
            int y=(l2==null)?0:l2.val;
            node.val=(x+y+carry);
            carry=0;
            if(node.val>9){
                carry=node.val/10;
                node.val=node.val%10;
            }
            curr.next=node;
            curr=curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return buffer.next;
    }
}

// ### Approach

// The digits in both linked lists are stored in **reverse order**, so we can add them directly from left to right, just like performing normal addition from the least significant digit.

// I use a **dummy node** to simplify construction of the result list and a `curr` pointer to keep track of the last node.

// For every position:

// 1. Get the current digit from `l1`. If `l1` is `null`, treat its digit as `0`.
// 2. Do the same for `l2`.
// 3. Calculate:
//    `sum = x + y + carry`
// 4. The digit to store in the result is:
//    `sum % 10`
// 5. The carry for the next position is:
//    `sum / 10`
// 6. Move `l1` and `l2` forward only if they are not `null`.

// The two linked lists can have **different lengths**, so when one list ends, its remaining digits are treated as `0`.

// The loop continues while either list still has nodes **or there is a remaining carry**. This is important for cases such as `9 + 1 = 10`, where an extra node is required for the final carry.

// ### Complexity

// * **Time Complexity:** O(max(n, m)), where `n` and `m` are the lengths of the two lists.
// * **Space Complexity:** O(max(n, m)) for the resulting linked list.

// The solution processes each digit exactly once and uses only constant extra space apart from the output list.
