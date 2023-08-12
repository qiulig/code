package company.Эјвз;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long []res = new long[t];
        int index = 0;
        while (t-- > 0) {
            long N = sc.nextLong();
            long M = sc.nextLong();
            if (N > M) {
                long temp = N;
                N = M;
                M = temp;
            }
            if (N == 1 && M == 1) {
               res[index++] = 1;
            } else if (N == 1 && M > 1) {
                res[index++] = M - 2;
            } else if(N > 1 && M > 1){
               res[index++] = (N - 2) * (M - 2);
            }else{
                res[index++] = 0;
            }
        }
        for(int i = 0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
    }
