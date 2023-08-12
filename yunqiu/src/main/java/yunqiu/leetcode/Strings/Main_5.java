package yunqiu.leetcode.Strings;

import static java.lang.Math.min;

/**
 * 最长回文子串
 */
public class Main_5 {
    /**
     * 暴力递归算法
     * @param str
     * @return
     */
//    public static String longestPalindrome(String s) {
//        String temp = "";
//        String res  ="";
//        for(int i = 0;i<s.length();i++){
//            for(int j = i;j<s.length();j++){
//                temp = temp+s.charAt(j);
//                String re  = new StringBuffer(temp).reverse().toString();
//                if(temp.equals(re)){
//                    res = res.length()>temp.length()?res:temp;
//                }
//            }
//            temp = "";
//        }
//        return res;
//    }

    /**
     * 动态规划算法
     * @param str
     * @return
     */
    public static String longestPalindrome(String str) {
        if(str.length()==0||str.length()==1)
            return str;
        int max = 1;
        int start = 0;
        int dp[][] = new int[str.length()][str.length()];
        for(int i =0;i<str.length();i++){
            dp[i][i]  = 1;
            if(i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                dp[i][i+1] = 1;
                max =i+1;
                start = i;
            }
        }
        for(int l=3;l<=str.length();l++)//l表示检索的子串长度，等于3表示先检索长度为3的子串
        {
            for(int i=0;i+l-1<str.length();i++)
            {
                int j=l+i-1;//终止字符位置
                if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==1)//状态转移
                {
                    dp[i][j]=1;
                    start=i;
                    max=l;
                }
            }
        }
        return str.substring(start,max);//获取最长回文子串
    }
    /**
     * 中心扩展
     */
    public static String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //奇数的回文，中心有一个字母，以该字母往外扩
            int len2 = expandAroundCenter(s, i, i + 1);  //偶数的回文，中心有两个字母，以这两个字母往外扩
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    /**
     * 方法四:马拉车算法
     * @param s
     * @return
     */
    public static String Manacher(String s) {
        String t = "$#";
        for (int i = 0; i < s.length(); ++i) {
            t += s.charAt(i);
            t += "#";
        }
        t+="$";
        // Process t
        int []p = new int[t.length()];
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length()-1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (t.charAt(i + p[i]) == t.charAt(i-p[i]))
                ++p[i];
            if ((mx-i) <  p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome3("cbbd"));
        System.out.println(Manacher("cbbd"));
    }
}
