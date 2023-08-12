package yunqiu.leetcode.Arrays.动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 122.买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Main_122_买卖股票的最佳时机ii {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    //加一个条件，只有手上没有股票的时候才能买入
    public static int maxProfit(int[] prices) {
        //dp[i][0]代表第i+1天没有持股票，
        //dp[i][1]代表第i+1天持有股票
        int dp[][] = new int[prices.length][2];
        //第一天没有持股，这时候相当于没有买入，故为0
        dp[0][0] = 0;
        //第一天持股，相当于买入，这时候为-pricrs[0]
        dp[0][1] = -prices[0];
        //求第(i+1)天持股或者不持股的最大收益
        for(int i = 1;i<dp.length;i++){
            //没有持股 =max(昨天没有持股今天维持现状 , 昨天持股，今天卖出）
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //持股 = max(昨天持股今天维持现状，（昨天没有持股，今天买入))
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        //最大利益肯定是那天没有持股时的利益
        return dp[dp.length-1][0];
    }
}
