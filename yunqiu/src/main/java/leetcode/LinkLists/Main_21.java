package leetcode.LinkLists;

public class Main_21 {

    //* Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null)
            return l2;
        if (l2 == null && l1 != null)
            return l1;
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            } else {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }
        }
        while (l1 != null) {
            res.next = new ListNode(l1.val);
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            res.next = new ListNode(l2.val);
            l2 = l2.next;
            res = res.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        mergeTwoLists(head1, head2);
    }
}
