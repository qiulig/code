package jianzhi_offer.Array;

/**
 * 求1+2+...+n
 */
public class Main_47_求和 {
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

    public static void main(String[] args) {
        //5个小朋友，喊到1的时候出局
        System.out.println(Sum_Solution(100));
    }
}
