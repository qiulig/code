package yunqiu.leetcode.LinkLists;

public class Main_19 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        if (curNode == null) {
            return preNode.next;
        }
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        preNode.next = preNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head,2));
    }
}
