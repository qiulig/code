package leetcode.LinkLists;

public class Main_203 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode removeElements(ListNode head, int val) {
            if (head == null)
                return head;
            //如果头节点与val相同
            while (head != null && head.val == val)
                head = head.next;
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }

            }
            return head;
        }
//        public static ListNode removeElements(ListNode head, int val) {
//            ListNode ans = new ListNode(-1);
//            ListNode res = ans;
//            while(head!=null){
//                if(head.val==val){
//                    head = head.next;
//                }else{
//                    ans.next =new ListNode(head.val) ;
//                    ans = ans.next;
//                    head = head.next;
//                }
//            }
//            return res.next;
//
//        }


        public static void main(String[] args) {
            ListNode l1 = new ListNode(6);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(6);
            l1.next.next.next = new ListNode(3);
            l1.next.next.next.next = new ListNode(4);
            l1.next.next.next.next.next = new ListNode(5);
            l1.next.next.next.next.next.next = new ListNode(6);
            ListNode res = removeElements(l1, 6);
            while (res != null) {
                System.out.print(res.val + " ");
                res = res.next;
            }
        }
    }
}
