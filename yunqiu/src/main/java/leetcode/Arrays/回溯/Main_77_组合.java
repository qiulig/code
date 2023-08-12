package leetcode.Arrays.回溯;
/**给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 示例:
 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 https://leetcode-cn.com/problems/combinations/
 **/
import java.util.List;
import java.util.ArrayList;
//执行用时 :40 ms, 在所有 Java 提交中击败了52.77%的用户
//内存消耗 :52.5 MB, 在所有 Java 提交中击败了26.41%的用户
public class Main_77_组合 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k,n,1,new ArrayList(),res);
        return res;
    }
    public static void backtrack(int k,int n,int start,List<Integer> tmplist,List<List<Integer>> result){
        if(k == 0){
            result.add(new ArrayList<>(tmplist));
        }else {
            for (int i = start; i <= n; i++) {
                tmplist.add(i);
                //递归
                backtrack( k - 1, n, i+1,tmplist, result);
                tmplist.remove(tmplist.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
