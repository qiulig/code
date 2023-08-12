package yunqiu.leetcode.Arrays;

import java.util.Stack;

/**
 * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ�������������磬121 �ǻ��ģ��� 123 ���ǡ�
 * ���ӣ�https://leetcode-cn.com/problems/palindrome-number
 */
public class Main_9_������ {

    public static boolean isPalindrome(int x) {
        String res = x+"";
        String ans = new StringBuilder(x+"").reverse().toString();
        if(res.equals(ans)){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome2(int x) {
        Stack<Integer> stack = new Stack<>();
        int res = x;
        if(x<0)
            return false;
        while(x>0){
            stack.push(x%10);
            x = x /10;
        }
        while (res>0){
            if(stack.pop()==res%10){
                res = res/10;
            }else {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome3(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;

    }
    public static void main(String[] args) {
        System.out.println(isPalindrome3(424));
    }
}
