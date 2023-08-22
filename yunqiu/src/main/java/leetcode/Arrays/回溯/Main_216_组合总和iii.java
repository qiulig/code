package leetcode.Arrays.回溯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。?
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
//执行用时 :5 ms, 在所有 Java 提交中击败了8.96%的用户
//内存消耗 :34.1 MB, 在所有 Java 提交中击败了28.88%的用户
public class Main_216_组合总和iii {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private static void backTrace(int k, int target, int start, ArrayList<Integer> tmpList, List<List<Integer>> res) {
        if (0 == k && target == 0) {
            Collections.sort(tmpList);
            if (!res.contains(tmpList))
                res.add(new ArrayList<>(tmpList));
        } else {
            for (int i = start; i <= 9; i++) {
                tmpList.add(i);
                backTrace(k - 1, target - i, i + 1, tmpList, res);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum3(2, 18);
    }

}

