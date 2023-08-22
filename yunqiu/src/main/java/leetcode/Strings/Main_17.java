package leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Main_17 {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        backtracking(list, "", digits, 0);
        return list;
    }

    private static void backtracking(List<String> list, String s, String digits, int flag) {
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (flag >= digits.length()) {
            list.add(s);
            return;
        }
        String chars = strings[digits.charAt(flag) - '0'];
        for (int i = 0; i < chars.length(); i++) {   //遍历一个数字对应的所有字母
            backtracking(list, s + chars.charAt(i), digits, flag + 1);
        }
    }

    public static void main(String[] args) {
        List<String> s = letterCombinations("23");
        for (String ss : s) {
            System.out.print(ss + " ");
        }
    }
}
