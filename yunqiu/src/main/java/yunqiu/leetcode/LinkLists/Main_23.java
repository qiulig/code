package yunqiu.leetcode.LinkLists;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_23 {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
//    public static ListNode mergeKLists(ListNode[] lists) {
//        ListNode res = new ListNode(-1);
//        ListNode ans = res;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for(int i = 0;i< lists.length;i++){
//            while(lists[i]!=null){
//                queue.add(lists[i].val);
//                lists[i] = lists[i].next;
//            }
//        }
//        while(queue.size()!=0){
//            res.next = new ListNode(queue.poll());
//            System.out.print(queue.peek()+" ");
//            res = res.next;
//        }
//        return ans.next;
//    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int i = mid,j=0; i < lists.length; i++,j++){
            l2[j] = lists[i];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(11);
        head1.next = new ListNode(12);
        head1.next.next = new ListNode(23);
        head1.next.next.next = new ListNode(24);
        head1.next.next.next.next = new ListNode(35);

        ListNode head2 = new ListNode(11);
        head2.next = new ListNode(22);
        head2.next.next = new ListNode(13);
        head2.next.next.next = new ListNode(14);
        head2.next.next.next.next = new ListNode(45);
        ListNode[]list = {head,head1,head2};
        mergeKLists(list);
    }
}
