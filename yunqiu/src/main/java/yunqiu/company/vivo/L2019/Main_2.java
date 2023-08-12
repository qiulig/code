package yunqiu.company.vivo.L2019;
//奇数位正序，偶数位逆序
public class Main_2 {
    static class  ListNode {
        int val;
        ListNode next ;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode hc = new ListNode(0);
        hc.next = new ListNode(1);
        hc.next.next = new ListNode(2);
        hc.next.next.next = new ListNode(3);
        hc.next.next.next.next = new ListNode(4);
        hc.next.next.next.next.next = new ListNode(5);
        hc.next.next.next.next.next.next = new ListNode(6);
        hc.next.next.next.next.next.next.next = new ListNode(7);

        solution(hc);
    }

    private static void solution(ListNode temp) {
        //奇数（正序输出）
        ListNode head = new ListNode(-1);
        ListNode odd = head;
        //偶数（需要逆序输出）
        ListNode tail = new ListNode(-1);
        ListNode even = tail;
        int i = 0;
        while (temp != null){
            //奇数位head
            if(i % 2 !=0){
                head.next = temp;
                temp  = temp.next;
                head = head.next;
            }else{ //偶数位逆序
                tail.next = temp;
                temp = temp.next;
                tail = tail.next;
            }
            i++;
        }
        //这个怎么说捏
        //假设是0--1--2--3
        //遍历到这的时候为  odd : -1 -- 0 -- 2 -- 3   even ： -1 -- 1 -- 3 ，所以要截断
        //反正 tail 或者 head 都会包含链表的最后一个值，有一个是不需要的。
        tail.next =null;
        head.next = null;
        //链表反转
        ListNode evenRes = reverseList(even.next);
        System.out.print("奇数位的排序为：");
        printRes(odd.next);
        System.out.println();
        System.out.print("偶数位的排序为：");
        printRes(evenRes);
    }

    private static void printRes(ListNode node) {
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    private static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
