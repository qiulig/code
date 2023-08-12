package yunqiu.jianzhi_offer.LinkLists;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Main_36_链表的公共结点 {

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public class Solution {
        public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null) {
                return null;
            }
            ListNode cur1 = head1;
            ListNode cur2 = head2;
            int n = 0;
            //得到差值步（head1.length-head2.length）
            while (cur1.next != null) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2.next != null) {
                n--;
                cur2 = cur2.next;
            }
            //相交为Y型则最后一个结点应该相同
            if (cur1 != cur2) {
                return null;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);//差值步
            //走差值步
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            //相等时则为相交点
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
    }
}
