package jianzhi_offer.LinkLists;

import java.util.Stack;

/**
 * 反转链表
 */
public class Main_15_反转链表 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public static ListNode ReverseList(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head!=null){
                stack.push(head.val);
                head = head.next;
            }
            ListNode temp = new ListNode(-1);
            ListNode res = temp;
            while(stack.size()!=0){
                temp.next  = new ListNode(stack.pop());
                temp = temp.next;
            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        ListNode res = Solution.ReverseList(head);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }

    }
}
