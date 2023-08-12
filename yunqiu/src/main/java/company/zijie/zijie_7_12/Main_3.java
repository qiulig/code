package company.zijie.zijie_7_12;

import java.util.Scanner;

/**
 *
 ■题目描述
    小W最近在做道小Q给的题，他们是好基友，小Q说这道题挺简单的。但是小W还没有做出来，小W也是要面子的，你能帮帮他吗?不能让小Q知道哦。题是这样的:
 给一个正整数n,找出最小的正整数x让满足y^2= n +x^2的整数y存在
 输入描述:
        一个数字 T(0<T<1000)，代表T行，每行一个数字n (1<=n<= 10^9)
 输出描述:
        对于每个n输出x,如果x不存在输出-1
 */

public class Main_3 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int result[]=test(nums);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }

    public static int[] test(int nums[]){
        int length=nums.length;
        int res[]=new int[length];
        for(int i=0;i<nums.length;i++){
            res[i]=solve(nums[i]);
        }
        return res;
    }

    public static int solve(int n ){
        //<<，有符号左移位，将运算数的二进制整体左移指定位数，低位用0补齐
        // 首先这边把x定义为int类型最大
        int x = (1<<30);
        // i是用来试探y-x的
        //因为y^2-x^2=n,(y-x)^2-(y^2-x^2)=2*x^2-2*x*y<0,所以（y-x）^2<n
        for(int i=1;i*i<=n;i++){
            if(n%i!=0) continue;
            //i&1判断是不是奇数,y^2-x^2=(x+y)*(y-x)，是同奇数同偶数的
            if( (i&1) == ( (n/i)&1 ) ){
                //   n/i-i=x  (n/i-i)=x,
                //  (n/i-i)/2>0
                if((n/i-i)/2>0 && (n/i-i)/2<x)
                    //得到y
                    x=(n/i-i)/2;
            }
        }
        if( x<(1<<30) )
            return x;
        else
            return -1;
    }
}