package yunqiu.leetcode.Arrays.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * https://leetcode-cn.com/problems/subsets/
 */
//执行用时 :2 ms, 在所有 Java 提交中击败了87.86%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了44.12%的用户
public class Main_78_子集 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums,0,new ArrayList<>(),res);
        return res;
    }

    private static void backTrace(int[] nums, int start, ArrayList<Integer> tmplist, List<List<Integer>> res) {
        res.add(new ArrayList<>(tmplist));
        for(int i = start;i<nums.length;i++){
            tmplist.add(nums[i]);
            backTrace(nums,i+1,tmplist,res);
            tmplist.remove(tmplist.size()-1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        subsets(nums);
    }


}

