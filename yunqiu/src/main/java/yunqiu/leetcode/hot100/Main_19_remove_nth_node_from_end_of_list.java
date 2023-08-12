package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. ɾ������ĵ����� N �����
 * ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 * ���ף����ܳ���ʹ��һ��ɨ��ʵ����
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

    //˼·��һ������list1����n������ô��list1��list2ͬʱ��ʱ����list1���꣬list2�պõ��ﵹ����n���ڵ㣬��ʱ��ѽڵ�ɾ������
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;
        //ʹ�������������n-1���ڵ�
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        //˵��ɾ������ͷ�ڵ�
        if (curNode == null) {
            return preNode.next;
        }
        //ͬʱ�ߣ�һֱ��curNode����ʱ��preNode�պõ��ﵹ����n���ڵ�ǰһ���ڵ�
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        //ɾ��������n�ڵ�
        preNode.next = preNode.next.next;

        return head;
    }
}
