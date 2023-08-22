package leetcode.LinkLists;

public class Main_ {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;  //将下一个节点记录
            cur.next = pre;  //当前节点指向上一个节点
            pre = cur;   //记录当前节点
            cur = next; //将下一个节点变成当前节点
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode res = reverse(l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
//        ListNode ans = reverseList(l1);
//        System.out.println();
//        while(ans!=null){
//            System.out.print(ans.val+ " ");
//            ans = ans.next;
//        }
    }
}
