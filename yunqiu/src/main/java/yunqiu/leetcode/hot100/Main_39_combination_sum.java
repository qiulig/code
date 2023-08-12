package yunqiu.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39.组合总数
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。

 */
public class Main_39_combination_sum {
    public static void main(String[] args) {
        int []candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        backTrace(ret,new ArrayList<>(),0,candidates,target);
        return ret;
    }

    private static void backTrace(List<List<Integer>> ret, ArrayList<Integer> temp, int start, int[] candidates, int target) {
        if(target == 0){
            ret.add(new ArrayList<>(temp));
        }else {
            //数组必须有序，不然不好做&&判断
            for(int i = start;i<candidates.length  && target >= candidates[i];i++){
                temp.add(candidates[i]);
                //这里因为可重复选择，所以下次回溯还可以再次选择当前的数，所以填入i
                backTrace(ret,temp,i,candidates,target-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
