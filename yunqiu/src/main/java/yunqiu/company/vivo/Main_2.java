package yunqiu.company.vivo;

/**
 *链表m-n个节点进行翻转
 * 3--5--6--1--2--3--4--6--4，m=4,n=7即反转过后
 * 3--5--6--4--3--2--1--6--4
 */
public class Main_2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode solution(int m ,int n ,ListNode head){
        if(head == null)
            return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = null;
        ListNode cur = head;
        for(int i  = 1;i<m;i++){
            pre = cur;
            cur = cur.next;
        }
        //head--1--2--3--4进行反转
        //先让头指针的next指向2，在让1的next指向3，最后将2的next指向1，完成第一次交换，顺序变成header--2--1--3--4,
        //然后进行相同的交换将结点3移动到结点2的前面，然后再将结点4移动到结点3的前面就完成了反转。
        //pre = 6--(1--2--3--4)--6--4
        //cur = (1--2--3--4)--6--4
        for(int i = m;i<n;i++){
            ListNode nextnode = cur.next; //nextnode = 2--3--4--6--4        3--4--6--4             4--6--4
            cur.next = nextnode.next;  //        cur = 1--3--4--6--4        1--4--6--4             1--6--4
            nextnode.next = pre.next; //    nextnode = 2--1--3--4--6--4     3--2--1--4--6--4       4--3--2--1--4--6--4
            pre.next = nextnode;   //            pre = 6--2--1--3--4--6--4  6--3--2--1--4--6--4    6--4--3--2--1--4--6--4
        }
        return res.next;



    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        ListNode node = solution(4,7,head);
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }

    }

}
