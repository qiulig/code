package company;


public class Main {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

        public static ListNode Merge(ListNode list1, ListNode list2) {
            ListNode result = new ListNode(0);
            ListNode cur = result;
            if (list1 == null && list2 == null) {
                return null;
            }
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }

            }
            if (list1 == null) {
                cur.next = list2;
            }
            if (list2 == null) {
                cur.next = list1;
            }
            return result.next;
        }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        Merge(head,head);
    }
    }