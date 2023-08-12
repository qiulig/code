package yunqiu.leetcode.LinkLists;

import java.util.Stack;

public class Main_24 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode swapPairs(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
            if(stack.size()==2){
                while(!stack.isEmpty()){
                    res.next = new ListNode(stack.pop());
                    res = res.next;
                }
            }
        }
        while(!stack.isEmpty()){
            res.next = new ListNode(stack.pop());
            res = res.next;
        }
        return ans.next;
    }
    public static ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode res =swapPairs(l1);
        while(res!=null){
            System.out.print(res.val+ " ");
            res = res.next;
        }
    }
}
