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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)  
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        
        Queue<ListNode> pq = new PriorityQueue(lists.size(), new ListNodeComparator());
        for (ListNode node : lists) 
            if (node != null)
                pq.offer(node);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pq.size() > 0) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null)
                pq.offer(cur.next);
        }
        return dummy.next;
    }
    
    private class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}