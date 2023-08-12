package yunqiu.leetcode.LinkLists;

public class Main_61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            if (k == 0 || head == null || head.next == null)
                return head;
            ListNode tempNode = head;
            int count = 0;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
                count++;
            }
            tempNode.next = head;
            if (k > count + 1) {
                k = k % (count + 1);
            }
            k = count + 1 - k;
            while (k > 0) {
                head = head.next;
                k--;
            }
            ListNode nextZeroNode = head;
            while (count > 0) {
                nextZeroNode = nextZeroNode.next;
                count--;
            }
            nextZeroNode.next = null;
            return head;
        }
        public ListNode mergeKLists1(ListNode[] lists) {
            if(lists==null||lists.length==0)
                return null;
            ListNode cur=new ListNode(0);
            cur.next=lists[0];
            for(int i=1;i<lists.length;i++){
                ListNode nodei=new ListNode(0);
                nodei.next=lists[i];
                while(cur.next!=null&&nodei.next!=null){
                    if(cur.next.val>=nodei.next.val){
                        ListNode temp=cur.next;
                        cur.next=nodei.next;
                        cur.next.next=temp;
                        nodei=nodei.next;
                    }else{
                        cur=cur.next;
                    }
                }
            }
            return cur.next;

        }

        public static void main(String[] args) {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(3);
            l1.next.next.next = new ListNode(4);
            l1.next.next.next.next = new ListNode(5);
            rotateRight(l1,2);

        }
    }


}
