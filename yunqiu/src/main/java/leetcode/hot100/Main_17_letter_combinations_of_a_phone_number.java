package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17.电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

public class Main_17_letter_combinations_of_a_phone_number {
    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        char[] chars = digits.toCharArray();
        //用于存储一次回溯得到的结果
        StringBuilder temp = new StringBuilder();
        backtrack(res, map, digits, 0, temp);
        return res;
    }

    private static void backtrack(List<String> ret, Map<Character, String> map, String digits, int start, StringBuilder temp) {
        //当前索引到达了字符串尾部，说明得到了一个分支的值，将其添加到结果集合
        if (start == digits.length()) {
            ret.add(temp.toString());
        } else {
            //最开始的一个数字
            char digit = digits.charAt(start);
            //数字对应的字母
            String letters = map.get(digit);
            //字母的个数
            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) {
                temp.append(letters.charAt(i));
                backtrack(ret, map, digits, start + 1, temp);
                //回溯到上一个节点
                temp.deleteCharAt(start);
            }
        }
    }
}