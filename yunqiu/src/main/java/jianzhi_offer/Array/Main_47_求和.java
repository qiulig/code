package jianzhi_offer.Array;

/**
 * ��1+2+...+n
 */
public class Main_47_��� {
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        //5��С���ѣ�����1��ʱ�����
        System.out.println(Sum_Solution(100));
    }
}
