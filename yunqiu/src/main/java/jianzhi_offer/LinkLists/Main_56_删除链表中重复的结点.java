package jianzhi_offer.LinkLists;

import java.util.ArrayList;

public class Main_56_删除链表中重复的结点 {

 public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public static class Solution {
        public static ListNode deleteDuplication(ListNode pHead) {
            ArrayList<Integer> ss = new ArrayList<>();
            ArrayList<Integer> ss2 = new ArrayList<>();
            ListNode res = new ListNode(-1);
            ListNode node = res;
            while(pHead!=null){
                if(!ss.contains(pHead.val)&& !ss2.contains(pHead.val)){
                    ss.add(pHead.val);
                    pHead = pHead.next;
                }else{
                    ss2.add(pHead.val);
                    ss.remove(Integer.valueOf(pHead.val));
                    pHead = pHead.next;
                }
            }
            for(int i = 0;i<ss.size();i++){
                res.next =new ListNode(ss.get(i));
                res = res.next;
            }
            return node.next;
        }

        public static ListNode deleteDuplication2(ListNode pHead) {
            if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
                return pHead;
            }
            if (pHead.val == pHead.next.val) { // 当前结点是重复结点
                ListNode pNode = pHead.next;
                while (pNode != null && pNode.val == pHead.val) {
                    // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                    pNode = pNode.next;
                }
                return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
            } else { // 当前结点不是重复结点
                pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
                return pHead;
            }
        }


        public static void main(String[] args) {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(3);
            node.next.next.next.next = new ListNode(3);
            deleteDuplication2(node);
        }
    }
}
