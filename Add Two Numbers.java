/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            int curSum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + carry;
            ListNode node = new ListNode(curSum % 10);
            carry = curSum / 10;
            cur.next = node;
            cur = node;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        if (carry == 1) 
            cur.next = new ListNode(1);
        return dummy.next;
    }
}