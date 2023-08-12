package jianzhi_offer.LinkLists;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Main_55_链表中环的入口结点 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    //快慢指针
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //在环中某一点相遇，将fast指针再次拨向头指针
            if(fast==slow){
                fast=pHead;
            }
            //调整指针速度，两点再次相遇即为入口结点
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
