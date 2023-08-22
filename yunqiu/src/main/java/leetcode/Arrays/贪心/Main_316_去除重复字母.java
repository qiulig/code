package leetcode.Arrays.贪心;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class Main_316_去除重复字母 {
    public static String removeDuplicateLetters(String s) {
        //创建一个栈存放去重结果
        Stack<Character> stack = new Stack<Character>();
        //创建布尔数组，记录栈中是否存在某个元素,长度为256,默认为false
        boolean[] inStack = new boolean[256];
        //维护一个计数器，记录字符串中字符的数量
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            //每访问一个字符，计数器中对应数字减一
            count[c]--;
            //如果栈中已存在，则访问下一个字符
            if (inStack[c])
                continue;
            //插入前与栈顶元素比大小
            while (!stack.isEmpty() && stack.peek() > c) {
                //若之后不存在栈顶元素了，则停止pop
                if (count[stack.peek()] == 0) {
                    break;
                }
                //若之后还有栈顶元素，则可以pop
                inStack[stack.pop()] = false;
            }
            //栈中没有该元素，则将其放入栈中
            stack.push(c);
            inStack[c] = true;
        }
        //拼接字符
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //返回结果
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcaed"));
    }
}
