package yunqiu.leetcode.Arrays.动态规划;

import java.util.Arrays;

public class Main {
    //给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
    public int numSquares(int n) {
        //dp[i] 表示加和为 i 的最少完全平方数的个数.
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0;i * i <= n;i++){
            dp[i * i] = 1;
        }
        for(int i = 0;i<=n;i++){
            for(int j = 1;j<=i;j++){
                if(i>=j *j)
                    dp[i] = Math.min(dp[i],dp[i - j * j] +1);
            }
        }
        return dp[n];
    }
    //给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
    //最少需要分割几次?
    private static boolean[][] getIsPalindrome(String s) {
       boolean isPalindrome[][] = new boolean[s.length()][s.length()];
       for(int i = 0;i<s.length();i++){
           isPalindrome[i][i] = true;
       }
       for(int i = 0;i<s.length()-1;i++){
           isPalindrome[i][i+1] = s.charAt(i)==s.charAt(i+1);
       }

       for(int i = 2;i<s.length();i++){
           for(int start = 0;start + i <s.length();start++){
               isPalindrome[start][start + i] = isPalindrome[start +1][start + i - 1] && s.charAt(start)==s.charAt(start + 2);
           }
       }
       return isPalindrome;
    }
    // dp[i] 表示原串的前 i 个字符最少分割多少次可以使得到的都是回文子串.
    public static int minCut(String s) {
        if(s==null || s.length() == 0){
            return 0;
        }
        boolean [][]isPalindrome = getIsPalindrome(s);

        int dp[] = new int[s.length()+1];
        dp[0] = 0;
        for(int i = 1;i<s.length();i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j<i;j++){
                if(isPalindrome[j][i-1]){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[s.length()] -1;
    }

    public static void main(String[] args) {
        minCut("aab");
    }
}
