package yunqiu.leetcode.hot100;

import java.util.ArrayList;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 46.全排列
 */
public class Main_46_permutations {
    public static void main(String[] args) {
        int []nums={1,2,3};
        List<List<Integer>> ret = permute(nums);
       for(List<Integer> it:ret){
           System.out.println(it);
       }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backTrace(ret,nums,new ArrayList<Integer>(),0);
        return ret;
    }

    private static void backTrace( List<List<Integer>> res,int[] nums, ArrayList<Integer> tempList, int start) {
        //start为边界值
        if(start == nums.length){
            if(!res.contains(tempList)){
                res.add(new ArrayList<>(tempList));
            }
        }
        for(int i = start;i<nums.length;i++){
            swap(nums,start,i);
            tempList.add(nums[start]);
            backTrace(res,nums,tempList,start+1);
            tempList.remove(tempList.size()-1);
            swap(nums,start,i);
        }
    }
    private static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }


}
