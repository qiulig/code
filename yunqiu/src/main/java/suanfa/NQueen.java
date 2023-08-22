package suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//执行用时 :9 ms, 在所有 Java 提交中击败了53.89%的用户
//内存消耗 :39.3 MB, 在所有 Java 提交中击败了84.75%的用户
public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
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
        return res;
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
        solveNQueens(4);
    }
}
