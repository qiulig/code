package leetcode.LinkLists;

import java.util.ArrayList;
import java.util.List;

public class Main_82 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur.next != null) {
            if (!list.contains(cur.next.val)) {
                list.add(cur.next.val);
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
//            ListNode node=new ListNode(-1);
//            node.next=head;
//            ListNode cur=node;
//            List<Integer> list=new ArrayList<>();
//            while (cur.next!=null){
//                if(list.contains(cur.next.val)){
//                    cur.next=cur.next.next;
//                }else{
//                    list.add(cur.next.val);
//                    cur=cur.next;
//                }
//
//            }
//            return node.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
