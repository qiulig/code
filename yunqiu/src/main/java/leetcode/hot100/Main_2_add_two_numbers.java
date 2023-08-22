package leetcode.hot100;

// Definition for singly-linked list.

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 2���������
 * ���������ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ�������ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢һλ���֡�
 * <p>
 * ���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
 * <p>
 * ����Լ���������� 0 ֮�⣬���������������� 0��ͷ��
 **/
public class Main_2_add_two_numbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode a = new ListNode(4);
        ListNode a1 = new ListNode(3);
        l1.next = a;
        a.next = a1;
        System.out.println();
        ListNode l2 = new ListNode(5);
        ListNode b = new ListNode(6);
        ListNode b1 = new ListNode(4);
        l2.next = b;
        b.next = b1;
        ListNode s = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
