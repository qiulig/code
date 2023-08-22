package leetcode.LinkLists;

/**
 * 给出两个 **非空** 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 **逆序** 的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * *示例：
 * *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * *输出：7 -> 0 -> 8
 * *原因：342 + 465 = 807
 */
public class Main_2 {
    //leetcode第二题：两数相加
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ress = new ListNode(0);
        ListNode res = ress;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int value = x + y + flag;
            flag = value / 10;
            res.next = new ListNode(value % 10);
            res = res.next;   //
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (flag > 0)
            res.next = new ListNode(flag);
        return ress.next;
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

}
