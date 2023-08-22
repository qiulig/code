package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22.���ŵ�����
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 * ��Ч������������㣺�����ű�������ȷ��˳��պϡ�
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
        //���������������� nn�����ǿ��Է�һ��������
        if (open < number / 2) {
            temp.append('(');
            backTrack(ret, temp, open + 1, close, number);
            temp.deleteCharAt(temp.length() - 1);
        }
        //����������С�������ŵ����������ǿ��Է�һ�������š�
        if (close < open) {
            temp.append(')');
            backTrack(ret, temp, open, close + 1, number);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
