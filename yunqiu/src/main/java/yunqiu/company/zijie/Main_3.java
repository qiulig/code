package yunqiu.company.zijie;
/**
 * 题目描述
 *      N个人围成圈顺序编号，从1号开始按1、2、3顺序报数，报3者退出圈外，其余的人再从1、2、3开始报数，报3的人再退出圈外，
 *      依次类推。请按退出顺序输出每个退出人的原序号。要求使用环行链表编程
 *输入描述:
 *      输入第一行为整数表示有一组测试数据，接下来m行每行一个整数N, N不超过50
 *输出描述:
 *      输出m行，每行表示题目所求，用空格隔开
 * 示例1
 *      输入
 *         1
 *         4
 *      输出
 *         3  2  4  1
 */
import java.util.LinkedList;
import java.util.Scanner;
public class Main_3 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //约瑟夫环，链表实现
    public static void solution(int total,int keyNumber){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            list.add(i+1);
        }
        int index = 0;
        while (list.size() > 1) {
            //报数
            for (int i = 1; i < keyNumber; i++) {
                if (index == list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
            }
            System.out.print(list.remove(index)+" ");
        }
        System.out.println( list.get(0) );
    }
    //循环链表的建立
    public static ListNode createNodes(int total){
        ListNode head = null;
        //创建每个指针节点
        ListNode [] nodes = new ListNode[total];
        for(int i = 0;i<total;i++){
            //每个节点的编号数
            nodes[i] = new ListNode(i+1);
            if(i == 0){
                //头节点为编号 1
                head = nodes[i];
            }else{
                //上一个节点的编号数指向下一个人的编号
                nodes[i-1].next = nodes[i];
            }
        }
        //最后一个节点指向头节点，变成循环链表
        nodes[total-1].next = head;
        return head;
    }
    public static void solution(int total){
        int n = total;
        int m = 3;
        m %= n;
        ListNode head = createNodes(total);
        //循环结束条件，即链表还剩下一个数，他们俩互指
        while (head.next !=head){
            //报数
            for(int i = 1;i<m-1;i++){
                head = head.next;
            }
            //找到报数为3的那个人
            ListNode temp = head.next;
            System.out.print(temp.val+" ");
            //将报数为3的那个移除循环列表
            head.next = temp.next;
            head = head.next;
        }
        System.out.println(head.val);
    }
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int nums = sr.nextInt();
        int m = sr.nextInt();
        for(int i = 0;i<nums;i++){
//            solution(m,3);
            solution(m);
        }
    }
}
