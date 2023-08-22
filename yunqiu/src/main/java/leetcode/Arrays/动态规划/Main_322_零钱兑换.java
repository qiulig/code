package leetcode.Arrays.动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class Main_322_零钱兑换 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        System.out.println(coinChange(arr, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        //dp[i]表示钱数为i时最少硬币数
        int dp[] = new int[amount + 1];
        //初始化钱数为i时的硬币数
        Arrays.fill(dp, amount + 1);
        //钱数为0时的最少硬币数也为0
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
