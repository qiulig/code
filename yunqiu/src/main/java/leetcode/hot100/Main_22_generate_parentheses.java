package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22.括号的生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class Main_22_generate_parentheses {
    public static void main(String[] args) {
        List<String> ret = generateParenthesis(3);
        ret.forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backTrack(ret, new StringBuilder(), 0, 0, 2 * n);
        return ret;
    }

    private static void backTrack(List<String> ret, StringBuilder temp, int open, int close, int number) {
        if (temp.length() == number) {
            ret.add(temp.toString());
            return;
        }
        //左括号数量不大于 nn，我们可以放一个左括号
        if (open < number / 2) {
            temp.append('(');
            backTrack(ret, temp, open + 1, close, number);
            temp.deleteCharAt(temp.length() - 1);
        }
        //右括号数量小于左括号的数量，我们可以放一个右括号。
        if (close < open) {
            temp.append(')');
            backTrack(ret, temp, open, close + 1, number);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
