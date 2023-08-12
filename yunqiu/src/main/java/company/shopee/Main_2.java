package company.shopee;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int weight[] = new int[n];
        for(int i = 0;i<n;i++){
            weight[i] = sr.nextInt();
        }
        int a[] = new int[n-1];
        int b[] = new int[n-1];
        for(int i = 0;i<n-1;i++){
            a[i] = sr.nextInt();
            b[i] = sr.nextInt();

        }
    }
}
