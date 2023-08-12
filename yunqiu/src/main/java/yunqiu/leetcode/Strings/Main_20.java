package yunqiu.leetcode.Strings;

import java.util.Stack;

/**
 *   给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。
 */
public class Main_20 {
        public static boolean isValid(String str) {
            Stack<Character> stack = new Stack();
            for(int i = 0;i<str.length();i++){
                if(str.charAt(i) == '('){
                    stack.push(')');
                } else if(str.charAt(i) == '{'){
                    stack.push('}');
                } else if(str.charAt(i) == '['){
                    stack.push(']');
                }else if(stack.isEmpty()||stack.pop()!=str.charAt(i)){
                    return false;
                }
            }
            return stack.isEmpty();
        }

    public static void main(String[] args) {
        System.out.println(isValid("()[]([)]"));
    }
}
