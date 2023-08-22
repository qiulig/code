package leetcode.Arrays;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 */
public class Main_10_正则表达式匹配 {
    public static boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null)
            return false;

        return matchCore(str.toCharArray(), 0, pattern.toCharArray(), 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        //   //如果当前pattern的下一个是*并且没有超出pattern的长度时
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // //如果当前字符str[index]和pattern[index]相等，或者当前pattern为‘.’
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符(当前pattern[index+1]='*'且str[index]!=pattern[index]）
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符 (当前pattern[i+1]='*'且str[index]=pattern[index])
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个（当前pattern[index]='.'）
            } else {
                //当前字符str[index]和pattern[index]不相等&&当前pattern不为‘.’
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        //pattern[index]='.'的情况，strindex和pattern都加1向下匹配
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    //别人给的动态规划的答案
    public static boolean isMatch2(String s, String p) {
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


    public static void main(String[] args) {
        System.out.println(isMatch2("ab", "a*b"));
    }
}
