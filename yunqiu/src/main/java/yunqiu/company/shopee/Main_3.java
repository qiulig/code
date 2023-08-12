package yunqiu.company.shopee;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int m = sr.nextInt();
        int a [] = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sr.nextInt();
        }
        System.out.println(solution(n,m,a));
    }

    private static long solution(int n, int m, int[] a) {
        long right = n * 7;
        long left = n;
        long ans = right;
        while (left<=right){
            long mid = (left+right)/2;
            if(check(mid,n,a,m)){
                ans = Math.min(mid,ans);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private static boolean check(long length,int n,int a[],int minute) {
        long cnt = 0;
        long temp = 0;
        for(int i = 0;i<n;i++){
            if(temp + a[i] <= length){
                temp += a[i];
            }else{
                temp = a[i];
                cnt++;
            }
        }
        return minute >= cnt + 1;
    }
}
