package yunqiu.leetcode.hot100;

/**
 *
   https://leetcode-cn.com/problems/merge-two-sorted-lists/
   21.合并两个有序列表
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Main_21_merge_two_sorted_lists {

    public static void main(String[] args) {
       ListNode head = new ListNode(1);
       ListNode head1 = new ListNode(2);
       ListNode head2 = new ListNode(4);

        head1.next = head2;
        head.next = head1;
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        head4.next = head5;
        head3.next = head4;

        mergeTwoLists(head,head3);
        System.out.println();
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null &&l2!=null)
            return l2;
        if(l2 == null && l1!=null)
            return l1;
        ListNode ret = new ListNode(-1);
        ListNode head = ret;
        while (l1!=null && l2!=null){
            if(l1.val <l2.val){
                ret.next = new ListNode(l1.val);
                l1 = l1.next;
                ret = ret.next;
            }else{
                ret.next = new ListNode(l2.val);
                l2 = l2.next;
                ret = ret.next;
            }
        }
        while (l1 !=null){
            ret.next = new ListNode(l1.val);
            ret = ret.next;
            l1 = l1.next;
        }
        while (l2 != null){
            ret.next = new ListNode(l2.val);
            ret = ret.next;
            l2 = l2.next;
        }
        return head.next;

    }
}
