package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 正则表达式匹配
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 */
public class Main_10_regular_expression_matching {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a*"));
    }
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //i= 0，j= 0表示str和pattern为空串，匹配成功标true
        dp[0][0] = true;
        //str为空串，pattern不为空串的情况
        for (int i = 0; i < p.length(); i++) {
            //前一个为true后一个为*，*匹配0个，则标记下一个为true
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //当前字母匹配，字符str和pattern都后移动一位
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //后一个字符是*
                if (p.charAt(j) == '*') {
                    //str与pattern不匹配
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        //str不变，pattern后移动两位
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //匹配0次，str不动，pattern后移2位，匹配一次，str移动一位，pattern移动2位，匹配多次，str移动1次，pattern不动
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                    }
                }
            }

        }
        return dp[s.length()][p.length()];
    }
}
