package yunqiu.leetcode.hot100;

import java.util.Locale;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5.������Ӵ�
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
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

        //dp[i][j]�����ַ���������i��j�Ƿ��ǻ��ġ��ǵĻ�Ϊtrue
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0;i<s.length();i++){
                dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        //ö���Ӵ��ĳ���
        for(int length = 2;length<=s.length();length++){
            //ö����߽�
            for(int left = 0;left<s.length();left++){
                //ȷ���ұ߽�����
               int right = left+length-1;
               if(right>=len){
                   break;
               }
               //�����ߵĺ��ұߵĲ������Ϊ�����Ӵ�
               if(chars[left] != chars[right]){
                   dp[left][right] = false;
               }else {
                   //��Ȳ��ҳ���<3��ֱ��Ϊ�����Ӵ�
                   if(right-left<3){
                       dp[left][right] = true;
                   }else{
                       //�Ƿ�Ϊ�����Ӵ������ڲ��Ӵ��Ƿ�Ϊ���ľ���
                       dp[left][right] = dp[left+1][right-1];
                   }
               }
               //��ǰΪ�����Ӵ������Ӵ����ȴ�����ǰ����м�¼
               if(dp[left][right]&& right-left+1>maxLen){
                   //������Ӵ��ĳ���
                   maxLen = right-left+1;
                   //�����Ӵ�����ߵ�����
                   begin = left;
               }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    //����2��������չ
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
