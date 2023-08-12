package yunqiu.leetcode.hot100;

import java.util.Locale;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Main_5_longest_palindromic_substring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len<2){
            return s;
        }

        //dp[i][j]代表字符串从索引i到j是否是回文。是的话为true
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
                dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        //枚举子串的长度
        for(int length = 2;length<=s.length();length++){
            //枚举左边界
            for(int left = 0;left<s.length();left++){
                //确定右边界索引
               int right = left+length-1;
               if(right>=len){
                   break;
               }
               //如果左边的和右边的不相等则不为回文子串
               if(chars[left] != chars[right]){
                   dp[left][right] = false;
               }else {
                   //相等并且长度<3则直接为回文子串
                   if(right-left<3){
                       dp[left][right] = true;
                   }else{
                       //是否为回文子串由其内部子串是否为回文决定
                       dp[left][right] = dp[left+1][right-1];
                   }
               }
               //当前为回文子串并且子串长度大于以前则进行记录
               if(dp[left][right]&& right-left+1>maxLen){
                   //最长回文子串的长度
                   maxLen = right-left+1;
                   //回文子串最左边的索引
                   begin = left;
               }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    //方法2：中心扩展
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

}
