package yunqiu.leetcode.Arrays.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
 */

public class Main_377_组合总和iv {
    //内存超出限制
    public static int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(nums,target,0,new ArrayList<>(),res);
        return res.size();
    }

    private static void backTrace(int[] nums, int target, int start, ArrayList<Integer> tmpList, List<List<Integer>> res) {
        if(target < 0){
            return;
        }else if(target == 0){
            res.add(new ArrayList<>(tmpList));
        }else{
            for(int i = 0;i<nums.length && target >= nums[i];i++){
                tmpList.add(nums[i]);
                backTrace(nums,target - nums[i],i,tmpList,res);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
    //dp动态规划,dp[i]代表组成target能有多少种 【答案错误】
    //无限背包问题，但是无限背包问题不能解决题目要求的顺序不同视为不同组合数
     public static int combinationSum5(int[] nums, int target) {
         int dp[] = new int[target + 1];
         int res = ZeroMorePackage(nums, nums, dp, nums.length, target);
         return res;
     }
    public static int ZeroMorePackage(int []weight,int []value,int []f,int Num,int total){
        for(int i = 0;i<Num;i++){
            for(int v = weight[i];v<=total;v++){ //注意是++
                f[v] = Math.max(f[v-weight[i]]+value[i],f[v]);
            }
        }
        return f[total];
    }
    //执行用时 :5 ms, 在所有 Java 提交中击败了68.54%的用户
    //内存消耗 :34.3 MB, 在所有 Java 提交中击败了39.00%的用户
    public static int combinationSum6(int[] nums, int target) {
        int dp[] = new int[target + 1];
        //初始化
        dp[0] = 1;
        for(int i = 1;i<=target;i++){
            for(int j = 0;j<nums.length;j++){
                if(i - nums[j] >= 0 ){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int nums[] ={1,2,3};
        int target = 4;
        combinationSum5(nums,target);
        combinationSum6(nums,target);
    }
}
