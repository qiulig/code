package leetcode.Arrays.动态规划;

/**
 * Created by qiulig on 2023/9/1
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Main_213_打家劫舍2 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // dpLast[i]表示不偷最后一家能获取的最大金额
        int[] dpLast = new int[len];
        dpLast[0] = nums[0];
        dpLast[1] = Math.max(nums[0], nums[1]);
        // dpFirst[]表示不偷第一家能获取的最大金额
        int[] dpFirst = new int[len];
        dpFirst[0] = 0;
        dpFirst[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dpLast[i] = Math.max(dpLast[i - 2] + nums[i], dpLast[i - 1]);
            dpFirst[i] = Math.max(dpFirst[i - 2] + nums[i], dpFirst[i - 1]);
        }
        return Math.max(dpLast[len - 2], dpFirst[len - 1]);
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 2};
        System.out.println(rob(nums));
    }
}
