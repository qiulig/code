package jianzhi_offer.LinkLists;

/**
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 */
public class Main_55_�����л�����ڽ�� {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    //����ָ��
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //�ڻ���ĳһ����������fastָ���ٴβ���ͷָ��
            if(fast==slow){
                fast=pHead;
            }
            //����ָ���ٶȣ������ٴ�������Ϊ��ڽ��
            while (fast!=slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }
}
