package leetcode.Arrays.��̬�滮;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 122.������Ʊ�����ʱ�� II
 * ����һ������ prices ������prices[i] ��һ֧������Ʊ�� i ��ļ۸�
 * <p>
 * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
 * <p>
 * ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 */
public class Main_122_������Ʊ�����ʱ��ii {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    //��һ��������ֻ������û�й�Ʊ��ʱ���������
    public static int maxProfit(int[] prices) {
        //dp[i][0]�����i+1��û�гֹ�Ʊ��
        //dp[i][1]�����i+1����й�Ʊ
        int dp[][] = new int[prices.length][2];
        //��һ��û�гֹɣ���ʱ���൱��û�����룬��Ϊ0
        dp[0][0] = 0;
        //��һ��ֹɣ��൱�����룬��ʱ��Ϊ-pricrs[0]
        dp[0][1] = -prices[0];
        //���(i+1)��ֹɻ��߲��ֹɵ��������
        for (int i = 1; i < dp.length; i++) {
            //û�гֹ� =max(����û�гֹɽ���ά����״ , ����ֹɣ�����������
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //�ֹ� = max(����ֹɽ���ά����״��������û�гֹɣ���������))
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //�������϶�������û�гֹ�ʱ������
        return dp[dp.length - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int dp[][] = new int[prices.length][2];
        // ��һ��û�ֹ�
        dp[0][0] = 0;
        // ��һ��ֹ�
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // ��i��û�ֹ�
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // ��i��ֹ�
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
