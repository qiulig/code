package leetcode.LinkLists;

public class Main_19 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;
        // curNode先行走n步
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        // 当前链表走了n步走到头了， 说明要删除的是个队头， 所以直接指向next就行
        if (curNode == null) {
            return head.next;
        }
        // curNode继续走（链表长度-n）, 此时pre节点刚好走到倒数第n+1位置
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        // 将n的位置替换成n的下一个位置
        preNode.next = preNode.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(head, 2));
    }
}
