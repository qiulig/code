package yunqiu.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
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