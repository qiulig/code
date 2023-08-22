package leetcode.Arrays;

/**
 * 乘积最大子序列********
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class Main_152 {
    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur_max = 1;
        int cur_min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = cur_max;
                cur_max = cur_min;
                cur_min = temp;
            }
            cur_max = Math.max(cur_max * nums[i], nums[i]);
            cur_min = Math.min(cur_min * nums[i], nums[i]);
            res = Math.max(res, cur_max);
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
