package leetcode.Arrays.��̬�滮;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * ��Ǯ�һ�
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
 * <p>
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ�����-1 ��
 * <p>
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 */
public class Main_322_��Ǯ�һ� {
    public static void main(String[] args) {
        int arr[] = {1, 2, 5};
        System.out.println(coinChange(arr, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        //dp[i]��ʾǮ��Ϊiʱ����Ӳ����
        int dp[] = new int[amount + 1];
        //��ʼ��Ǯ��Ϊiʱ��Ӳ����
        Arrays.fill(dp, amount + 1);
        //Ǯ��Ϊ0ʱ������Ӳ����ҲΪ0
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
