package jianzhi_offer.LinkLists;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Main_16_合并两个排序的链表 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static class Solution {
        public static ListNode Merge(ListNode list1,ListNode list2) {
            if(list1 == null && list2 == null)
                return null;
            if(list1 == null && list2 != null)
                return list2;
            if(list2 == null && list1 != null)
                return list1;
            ListNode tmp = new ListNode(-1);
            ListNode res = tmp;
            while(list1 != null && list2 != null){
                if(list1.val<list2.val){
                    tmp.next = new ListNode(list1.val);
                    tmp = tmp.next;
                    list1 = list1.next;

                }else{
                    tmp.next = new ListNode(list2.val);
                    tmp = tmp.next;
                    list2 = list2.next;

                }
            }
            while (list1!=null){
                tmp.next = new ListNode(list1.val);
                tmp = tmp.next;
                list1 = list1.next;

            }
            while(list2!=null){
                tmp.next = new ListNode(list2.val);
                tmp = tmp.next;
                list2 = list2.next;

            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        list1.next = l1;
        l1.next = l2;

        ListNode list2 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        list2.next = l11;
        l11.next = l22;
        ListNode res = Solution.Merge(list1,list2);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
