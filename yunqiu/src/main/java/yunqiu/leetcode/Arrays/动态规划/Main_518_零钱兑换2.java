package yunqiu.leetcode.Arrays.动态规划;
//执行用时 :7 ms, 在所有 Java 提交中击败了52.45%的用户
//内存消耗 :34.9 MB, 在所有 Java 提交中击败了64.83%的用户

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。?
 * 题目数据保证结果符合 32 位带符号整数。
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 */
public class Main_518_零钱兑换2 {
    public static void main(String[] args) {
        int coins [] = {1,2,5};
        System.out.println(change(5,coins));
    }
    public static int change(int amount, int[] coins) {
        //用dp[i]记录金额j可以有多少种硬币组合
       int dp[] = new int[amount +1];
       //初始化第一个，代表金额为1时的组合数即0+0+0+0...这1种组合
        dp[0] = 1;
        for(int i = 0;i<coins.length;i++){
            for(int j = 0;j<=amount;j++){ //依次更新钱数为0--amount的组合数
                if(j >= coins[i]){ //如果当前的钱比钱的面额大
                    dp[j] += dp[j-coins[i]];  //当前的组合数 =之前的组合数 + dp[j-coins[i]]的组合数
                }
            }
        }
        return dp[amount];
    }
}
