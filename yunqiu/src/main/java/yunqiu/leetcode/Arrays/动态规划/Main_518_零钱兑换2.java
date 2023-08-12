package yunqiu.leetcode.Arrays.��̬�滮;
//ִ����ʱ :7 ms, ������ Java �ύ�л�����52.45%���û�
//�ڴ����� :34.9 MB, ������ Java �ύ�л�����64.83%���û�

/**
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 * ����ÿһ������Ӳ�������޸���?
 * ��Ŀ���ݱ�֤������� 32 λ������������
 * ���ӣ�https://leetcode-cn.com/problems/coin-change-2
 */
public class Main_518_��Ǯ�һ�2 {
    public static void main(String[] args) {
        int coins [] = {1,2,5};
        System.out.println(change(5,coins));
    }
    public static int change(int amount, int[] coins) {
        //��dp[i]��¼���j�����ж�����Ӳ�����
       int dp[] = new int[amount +1];
       //��ʼ����һ����������Ϊ1ʱ���������0+0+0+0...��1�����
        dp[0] = 1;
        for(int i = 0;i<coins.length;i++){
            for(int j = 0;j<=amount;j++){ //���θ���Ǯ��Ϊ0--amount�������
                if(j >= coins[i]){ //�����ǰ��Ǯ��Ǯ������
                    dp[j] += dp[j-coins[i]];  //��ǰ������� =֮ǰ������� + dp[j-coins[i]]�������
                }
            }
        }
        return dp[amount];
    }
}
