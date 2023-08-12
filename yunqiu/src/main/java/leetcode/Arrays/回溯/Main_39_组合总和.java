package leetcode.Arrays.回溯;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/** 39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
 */
//执行用时 :3 ms, 在所有 Java 提交中击败了99.84%的用户
//内存消耗 :37.4 MB, 在所有 Java 提交中击败了96.85%的用户
public class Main_39_组合总和 {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            //存放结果
            List<List<Integer>> res = new ArrayList<>();
            //排序
            Arrays.sort(candidates);
            //从第一个数开始递归
            calculate(candidates,target,0,new ArrayList<>(),res);

            return res;
        }
    public static void calculate(int[] candidates,int target,int start,ArrayList<Integer> tmpList,List<List<Integer>> result) {
        //回溯
        if (target < 0) {
            return;
        }
        //存入结果集
        else if (target == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        } else {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                //加入
                tmpList.add(candidates[i]);
                //递归
                calculate( candidates, target - candidates[i], i, tmpList,result);
                //清空所得到的一次结果的list
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates= {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
}

