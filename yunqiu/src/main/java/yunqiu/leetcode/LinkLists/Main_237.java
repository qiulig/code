package yunqiu.leetcode.LinkLists;

public class Main_237 {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    static class Solution {
        public static void deleteNode(ListNode node) {
//            ListNode head = node.next;
//            int val = node.val;
//            if(head.next == null){
//                return ;
//            }
//            while(head.next != null){
//                if(head.next.val == val){
//                    head.next = head.next.next;
//                }else{
//                    head = head.next;
//                }
//            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
        public static void main(String[] args) {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(3);
            l1.next.next.next = new ListNode(4);
            l1.next.next.next.next = new ListNode(1);
            l1.next.next.next.next.next = new ListNode(4);
            deleteNode(l1);
        }
    }
}
