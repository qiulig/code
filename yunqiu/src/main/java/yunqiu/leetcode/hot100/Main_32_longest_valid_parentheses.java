package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32.���Ч����
 */
public class Main_32_longest_valid_parentheses {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        //dp[i]�����i��j�����Ч����
        int dp[] = new int[s.length()];
        int ret = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == ')' ){
                if (s.charAt(i - 1) == '(') {
                    //s[i]=��)�� �� s[i - 1] = ��(��}s[i?1]=��(����Ҳ�����ַ������� ������()��������()��
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ret = Math.max(ret,dp[i]);
            }
        }
        return ret;
    }
}
