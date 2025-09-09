package com.programs.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
class MergeKSortedList {
    /**
    One of the beautiful code I have ever seen
    **/
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
                    new NodeComparator());
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        //first push all the head nodes of the list to heap
        for(ListNode head : lists) {
            if(head != null) {
                queue.offer(head);
            }
        }
        
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            //use the head nodes of each list to traveerse and push
            if(tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return dummy.next;
    }
    
    public class NodeComparator implements Comparator<ListNode> {
        
        public int compare(ListNode n1, ListNode n2) {
            if(n1.val < n2.val) {
                return -1;
            } else if(n1.val > n2.val) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public static class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}