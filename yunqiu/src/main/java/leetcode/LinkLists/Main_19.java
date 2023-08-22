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
        // curNode������n��
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        // ��ǰ��������n���ߵ�ͷ�ˣ� ˵��Ҫɾ�����Ǹ���ͷ�� ����ֱ��ָ��next����
        if (curNode == null) {
            return head.next;
        }
        // curNode�����ߣ�������-n��, ��ʱpre�ڵ�պ��ߵ�������n+1λ��
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        // ��n��λ���滻��n����һ��λ��
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
