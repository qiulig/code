package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 * 1567.乘积为正数的最长子数组长度
 */
public class Main_1567_maximum_length_of_subarray_with_positive_product {
    public static void main(String[] args) {
        int nums[] = {0, 1, -2, -3, -4};
        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        //以下标 i 结尾的乘积为正数的最长子数组长度
        int[] positive = new int[len];
        //以下标 i 结尾的乘积为负数的最长子数组长度
        int[] negative = new int[len];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLen = positive[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                //正正得正
                positive[i] = positive[i - 1] + 1;
                //负正得负 ，若前一个为0，则相当于该子数组就num[i]一个值，而num[i]>0,故这种情况结果为0
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                //负（nums[i]）负(negative[i-1])得正;若前一个为0，则相当于该子数组就num[i]一个值，而num[i]<0,故这种情况结果为0
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                //负（nums[i]）正得负
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLen = Math.max(maxLen, positive[i]);
        }
        return maxLen;
    }
}
