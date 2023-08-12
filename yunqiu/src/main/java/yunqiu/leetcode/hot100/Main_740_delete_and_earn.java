package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/
 * 740.删除并获得点数
 * 给你一个整数数组nums，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class Main_740_delete_and_earn {
    public static void main(String[] args) {
        int nums []={3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
    public static int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        //求出最大的数，从而得到构建的桶的大小
        for(int i = 0;i<nums.length;i++){
            maxNum = Math.max(maxNum,nums[i]);
        }
        //放入桶中
        int[] number = new int[maxNum+1];
        for(int i = 0;i<nums.length;i++){
            number[nums[i]] +=nums[i];
        }
        //类似打家劫舍（不能打劫前后两家，即 题中的删除 所有 等于nums[i] - 1 和 nums[i] + 1的元素）
        int dp[] = new int[maxNum+1];
        dp[0] = number[0];
        dp[1] = Math.max(number[0],number[1]);
        for(int i = 2;i<maxNum+1;i++){
            dp[i] = Math.max(dp[i-2]+number[i],dp[i-1]);
        }
        return dp[maxNum];
    }
}
