package leetcode.LinkLists;

import java.util.Stack;

/**
 * »ØÎÄÁ´±í
 */
public class Main_234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public static boolean isPalindrome(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode res = head;
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            while (res != null) {
                if (stack.pop() == res.val) {
                    res = res.next;
                } else {
                    return false;
                }
            }
            return true;
        }

        public static boolean isPalindrome2(ListNode head) {
            ListNode head2 = head;
            ListNode prev = reverseListNode(head);
            while (head != null) {
                if (head.val == prev.val) {
                    head = head.next;
                    prev = prev.next;
                } else {
                    return false;
                }
            }
            return true;
        }

        private static ListNode reverseListNode(ListNode head) {
            ListNode prev = null;
            ListNode now = head;
            while (now != null) {
                ListNode next = now.next;
                now.next = prev;
                prev = now;
                now = next;
            }
            return prev;
        }


        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(1);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);
            System.out.println(isPalindrome(head));
            System.out.println(isPalindrome2(head));

        }
    }
}
