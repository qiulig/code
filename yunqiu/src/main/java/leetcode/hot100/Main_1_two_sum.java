package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
/*
https://leetcode-cn.com/problems/two-sum/
两数之和
给定一个整数数组 nums?和一个整数目标值 target，请你在该数组中找出 和为目标值 target? 的那?两个?整数，并返回它们的数组下标。
  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
   你可以按任意顺序返回答案。
*/

public class Main_1_two_sum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
        }
        return res;
    }
}
