package yunqiu.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20.��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
 *
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 */
public class Main_20_valid_parentheses {
    public static void main(String[] args) {
        System.out.println(isValid( "{]"));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(')');
            } else if(s.charAt(i) == '{'){
                stack.push('}');
            } else if(s.charAt(i) == '['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=s.charAt(i)){
                return false;
            }
        }
        return stack.isEmpty();
    }

}