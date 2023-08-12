package company.shopee;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int x = sr.nextInt();
        int y = sr.nextInt();
        int n = sr.nextInt();
        int [][] location = new int[x+1][y+1];
        for(int i = 0;i<n;i++){
            int x1 = sr.nextInt();
            int y1 = sr.nextInt();
            if(x1<=x  && y1<=y)
                location[x1][y1] = 1;
        }
        System.out.println(solution(location,x,y));

    }

    private static long solution(int[][] location, int x, int y) {

        long dp[][] = new long[x+1][y+1];
        //行初始化
        dp[0][0] = 1;
        for(int i = 1;i<=y;i++){
           dp[0][i] = location[0][i]==1 ? 0:dp[0][i-1];
        }
        //列初始化
        for(int i = 1;i<=x;i++){
            dp[i][0] = location[i][0]==1?1:dp[i-1][0];
        }
        //动态规划
        for(int i = 1;i<=x;i++){
            for(int j = 1;j<=y;j++){
                dp[i][j] = location[i][j] == 1 ? 0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[x][y];
    }
}
