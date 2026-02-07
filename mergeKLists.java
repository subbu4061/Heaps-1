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

// Solution -1

 // TimeComplexity: O(Nlogk) where N is total number of elements and where k is size of list
 // SpaceComplexity: O(k) where k is size of list
 // Explanation: I use a min-heap that initially stores the head of each non-empty list.
 // Every time I remove the smallest node from the heap and attach it to the result list. Then I push that node’s next pointer into the heap if it exists.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        ListNode root = new ListNode(-1);
        ListNode curr = root;
        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }
        while(pq.size()!=0){
            ListNode popped = pq.poll();
            curr.next = popped;
            curr =curr.next;
            if(popped.next!=null){
                pq.add(popped.next);
            }
        }
        return root.next;  
    }
}

// Solution-2

 // TimeComplexity: O(NlogN) where N is total number of elements
 // SpaceComplexity: O(N)
 // Explanation: In this approach, I insert every node from all lists into a min-heap first.
 //  Then I repeatedly poll from the heap and connect them in sorted order to form the final list.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        ListNode curr = new ListNode(-1);
        ListNode root = curr;
        for(int i=0; i<lists.length; i++){
            ListNode present = lists[i];
            if(present ==null) continue;
            while(present!=null){
                pq.add(present);
                ListNode prev= present;
                present = present.next;
                prev.next = null;
            }
        }
        while(pq.size()!=0){
            ListNode popped = pq.poll();
            curr.next = popped;
            curr =curr.next;
        }
        return root.next;   
    }
}
