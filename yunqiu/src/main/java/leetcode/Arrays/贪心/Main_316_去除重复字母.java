package leetcode.Arrays.̰��;

import java.util.Stack;

/**
 * ����һ���ַ��� s ������ȥ���ַ������ظ�����ĸ��ʹ��ÿ����ĸֻ����һ�Ρ��豣֤ ���ؽ�����ֵ�����С��Ҫ���ܴ��������ַ������λ�ã���
 */
public class Main_316_ȥ���ظ���ĸ {
    public static String removeDuplicateLetters(String s) {
        //����һ��ջ���ȥ�ؽ��
        Stack<Character> stack = new Stack<Character>();
        //�����������飬��¼ջ���Ƿ����ĳ��Ԫ��,����Ϊ256,Ĭ��Ϊfalse
        boolean[] inStack = new boolean[256];
        //ά��һ������������¼�ַ������ַ�������
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            //ÿ����һ���ַ����������ж�Ӧ���ּ�һ
            count[c]--;
            //���ջ���Ѵ��ڣ��������һ���ַ�
            if (inStack[c])
                continue;
            //����ǰ��ջ��Ԫ�رȴ�С
            while (!stack.isEmpty() && stack.peek() > c) {
                //��֮�󲻴���ջ��Ԫ���ˣ���ֹͣpop
                if (count[stack.peek()] == 0) {
                    break;
                }
                //��֮����ջ��Ԫ�أ������pop
                inStack[stack.pop()] = false;
            }
            //ջ��û�и�Ԫ�أ��������ջ��
            stack.push(c);
            inStack[c] = true;
        }
        //ƴ���ַ�
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //���ؽ��
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcaed"));
    }
}
