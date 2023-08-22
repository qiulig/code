package leetcode.Arrays.动态规划;

/**
 * 121.买股票的最佳时机
 */
public class Main_121_买卖股票的最佳时机合集 {
    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        System.out.println(maxProfit7(arr));
    }

    /**
     * 121
     * 给定一个数组 prices ，它的第?i 个元素?prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    //不限制买入情况
    public static int maxProfit2(int[] prices) {
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0];
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 1; i < dp.length; i++) {
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（昨天没有持股或者持股都行，今天买入))
            dp[i][1] = Math.max(dp[i - 1][1], -1 * prices[i]);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][0];
    }
    //加一个条件，只有手上没有股票的时候才能买入  122题

    /**
     * 122
     * 给定一个数组 prices ，其中?prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0];
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 1; i < dp.length; i++) {
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（昨天没有持股，今天买入))
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][0];
    }
    //等待一天才能交易，只能卖出再买入

    /**
     * 309 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第?i?个元素代表了第?i?天的股票价格 。?
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第2天没有持股，这时候max(第一天没持股，第一天持股第二天卖出)
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0];
        //第2天持股，这时候max(第一天持股，第一天没持股第二天买入)
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 2; i < dp.length; i++) {
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（前天没有持股，今天买入))
            ///*****第i天要买的时候，要从前天的状态进行判断*****
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][0];
    }

    /**
     * 714 买卖股票的最佳时机含手续费
     * 给定一个整数数组?prices，其中第?i?个元素代表了第?i?天的股票价格 ；整数?fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     *
     * @param prices
     * @param fee
     * @return
     */
    //卖出才能买入，每次卖出交易需要手续费
    public static int maxProfit5(int[] prices, int fee) {
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0] - fee;
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 1; i < dp.length; i++) {
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（昨天没有持股或者持股都行，今天买入))
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][0];
    }

    //
    public static int maxProfit6(int[] prices, int fee) {
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0];
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 1; i < dp.length; i++) {
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（昨天没有持股或者持股都行，今天买入))
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][0];
    }
    //在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，
    // 规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，
    // 请写一个程序计算一天可以获得的最大收益。
    //不限制买入情况

    /**
     * 123、买卖股票的最佳时机3
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成?两笔?交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     *
     * @param prices
     * @return
     */
    public static int maxProfit7(int[] prices) {
        if (prices.length == 0)
            return 0;
        //dp[i][k][0]代表第(i+1)天交易次数为2,没持股
        int dp[][][] = new int[prices.length][3][2];
        //初始化
        dp[0][1][0] = 0;  //第一天，交易次数为1，没持股
        dp[0][1][1] = -prices[0];  //第一天，买交易次数为1，卖次数为0，持股
        dp[0][2][0] = 0;   //第一天,买卖次数都不能达到2，没持股
        dp[0][2][1] = -prices[0];  //第一天，交易次数为2，持股

        for (int i = 1; i < prices.length; i++) {
            //第(i+1)天交易数为2，没持股 = max(前一天交易数为2没持股维持，前一天交易数为1持股今天卖出)
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            //第(i+1)天交易数为2，持股 = 前一天交易数为2持股维持，前一天交易数为1没持股今天买入
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            //第(i+1)天交易数为1，没持股 = max(前一天交易数为1没持股维持，前一天交易数为0持股今天卖出)
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //第(i+1)天交易数为1，持股 = max(前一天交易数为1持股维持，(没交易，今天买入))
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -1 * prices[i]);
//        }
        }
        //求最后一天能得到的最大收益
        return dp[prices.length - 1][2][0];
    }

    public static int maxProfit8(int[] prices, int k) {
        if (prices.length == 0)
            return 0;
        int dp[][][] = new int[prices.length][k + 1][2];
        //初始化
        dp[0][1][0] = 0;  //第一天，交易次数为1，没持股
        dp[0][1][1] = -prices[0];  //第一天，买交易次数为1，卖次数为0，持股
        if (k >= 2) {
            dp[0][2][0] = 0;   //第一天,买入卖出买入卖出，没收益
            dp[0][2][1] = -prices[0];  //第一天，交易次数为2，买入卖出买入
        }
        //求第(i+1)天持股或者不持股的最大收益
        for (int i = 1; i < dp.length; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length - 1][k][0];
    }

    public static int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k > n / 2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    for (int m = 1; m < max_k; m++) {
                        dp[i][m][0] = 0;
                        dp[i][m][1] = -prices[0];
                    }
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }

    public static int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
