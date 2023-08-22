package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17.�绰�������ĸ���
 * ����һ������������2-9���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * <p>
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
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
        //���ڴ洢һ�λ��ݵõ��Ľ��
        StringBuilder temp = new StringBuilder();
        backtrack(res, map, digits, 0, temp);
        return res;
    }

    private static void backtrack(List<String> ret, Map<Character, String> map, String digits, int start, StringBuilder temp) {
        //��ǰ�����������ַ���β����˵���õ���һ����֧��ֵ��������ӵ��������
        if (start == digits.length()) {
            ret.add(temp.toString());
        } else {
            //�ʼ��һ������
            char digit = digits.charAt(start);
            //���ֶ�Ӧ����ĸ
            String letters = map.get(digit);
            //��ĸ�ĸ���
            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) {
                temp.append(letters.charAt(i));
                backtrack(ret, map, digits, start + 1, temp);
                //���ݵ���һ���ڵ�
                temp.deleteCharAt(start);
            }
        }
    }
}