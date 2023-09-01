package leetcode.Arrays.��̬�滮;

/**
 * Created by qiulig on 2023/9/1
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Main_198_��ҽ��� {

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // dp[i] ��ʾ��i+1����������͵�Ե�����߽��
        int[] dp = new int[len];
        // ��ʾֻ��һ���ݵ�ʱ���ܵ��Ե���߽��
        dp[0] = nums[0];
        // ��ʾֻ�������ݵ�ʱ���ܵ��Ե���߽��
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // �ܵ��Ե������ = max(��ҵ���+���ϼҵ����� ��Ҳ����ԣ� �ϼҵ�����
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
