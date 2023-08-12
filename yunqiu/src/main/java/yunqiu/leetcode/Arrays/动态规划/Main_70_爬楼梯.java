package yunqiu.leetcode.Arrays.动态规划;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class Main_70_爬楼梯 {
        public static int climbStairs(int n) {
            if(n <= 2)
                return n ;
            int one = 1;
            int two = 2;
            int res = 0;
            for(int i = 3;i <=n ;i++){
                res = one + two;
                one = two;
                two = res;
            }
            return res;
        }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
