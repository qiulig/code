package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Main_19_remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;
        head.next = head1;
        removeNthFromEnd(head1,2);
        System.out.println();
    }
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //思路，一个链表list1先走n步，那么当list1跟list2同时走时，当list1走完，list2刚好到达倒数第n个节点，这时候把节点删除即可
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;
        //使得两个链表相差n-1个节点
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        //说明删除的是头节点
        if (curNode == null) {
            return preNode.next;
        }
        //同时走，一直到curNode，这时候preNode刚好到达倒数第n个节点前一个节点
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        //删除倒数第n节点
        preNode.next = preNode.next.next;

        return head;
    }
}
