package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/
 * 740.ɾ������õ���
 * ����һ����������nums������Զ�������һЩ������
 *
 * ÿ�β����У�ѡ������һ��nums[i]��ɾ���������nums[i]�ĵ�����֮�������ɾ�� ���� ����nums[i] - 1 �� nums[i] + 1��Ԫ�ء�
 *
 * ��ʼ��ӵ�� 0 ����������������ͨ����Щ������õ���������
 */
public class Main_740_delete_and_earn {
    public static void main(String[] args) {
        int nums []={3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        //������������Ӷ��õ�������Ͱ�Ĵ�С
        for(int i = 0;i<nums.length;i++){
            maxNum = Math.max(maxNum,nums[i]);
        }
        //����Ͱ��
        int[] number = new int[maxNum+1];
        for(int i = 0;i<nums.length;i++){
            number[nums[i]] +=nums[i];
        }
        //���ƴ�ҽ��ᣨ���ܴ��ǰ�����ң��� ���е�ɾ�� ���� ����nums[i] - 1 �� nums[i] + 1��Ԫ�أ�
        int dp[] = new int[maxNum+1];
        dp[0] = number[0];
        dp[1] = Math.max(number[0],number[1]);
        for(int i = 2;i<maxNum+1;i++){
            dp[i] = Math.max(dp[i-2]+number[i],dp[i-1]);
        }
        return dp[maxNum];
    }
}
