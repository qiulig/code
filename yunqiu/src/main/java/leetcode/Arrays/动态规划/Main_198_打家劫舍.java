package leetcode.Arrays.动态规划;

/**
 * Created by qiulig on 2023/9/1
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Main_198_打家劫舍 {

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // dp[i] 表示在i+1个房屋内能偷窃到的最高金额
        int[] dp = new int[len];
        // 表示只有一个屋的时候能盗窃的最高金额
        dp[0] = nums[0];
        // 表示只有两个屋的时候能盗窃的最高金额
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 能盗窃的最大金额 = max(这家盗窃+上上家的最大金额， 这家不盗窃， 上家的最大金额）
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
