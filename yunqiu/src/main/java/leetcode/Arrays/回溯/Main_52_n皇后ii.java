package leetcode.Arrays.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 */
//执行用时 :29 ms, 在所有 Java 提交中击败了5.45%的用户
//内存消耗 :34.8 MB, 在所有 Java 提交中击败了41.25%的用户
public class Main_52_n皇后ii {
    public static int totalNQueens(int n) {
        //用于存储行
        List<Integer> col = new ArrayList<>();
        //用于存储正对角线
        List<Integer> z_diagonal = new ArrayList<>();
        //用于存储负对角线
        List<Integer> f_diagonal = new ArrayList<>();
        //存储结果
        List<List<String>> res = new ArrayList<>();
        //从第一个row = 0开始
        backtrack(0, n, res, new ArrayList<String>(), col, z_diagonal, f_diagonal);
        return res.size();
    }

    public static void backtrack(int row, int NumOfQueen, List<List<String>> res, ArrayList<String> tmplist, List<Integer> col, List<Integer> z_diagonal, List<Integer> f_diagonal) {
        //到达了最后一行
        if (row == NumOfQueen) {
            res.add(new ArrayList<>(tmplist));
            return;
        }
        //从第0列开始遍历
        for (int column = 0; column < NumOfQueen; column++) {
            //如果不在攻击范围内（不在同一行或者同一列 && 负对角线和相等 &&  正对角线差相等）
            if (!col.contains(column) && !f_diagonal.contains(row + column) && !z_diagonal.contains(row - column)) {
                col.add(column);
                f_diagonal.add(row + column);
                z_diagonal.add(row - column);
                char[] s = new char[NumOfQueen];
                Arrays.fill(s, '.');
                //这一行的j位置放皇后
                s[column] = 'Q';
                tmplist.add(new String(s));
                //回溯算法
                backtrack(row + 1, NumOfQueen, res, tmplist, col, z_diagonal, f_diagonal);
                tmplist.remove(tmplist.size() - 1);
                col.remove(Integer.valueOf(column));
                f_diagonal.remove(Integer.valueOf(row + column));
                z_diagonal.remove(Integer.valueOf(row - column));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
