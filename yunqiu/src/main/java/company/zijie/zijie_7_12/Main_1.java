package company.zijie.zijie_7_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *给一个数字N,一直执行一种操作，如果这个数字可以开根得到一个整数，那么将这个数字开根(取sqrt) ，否则减一， 问执行多少次操作能把这个数字减到1
 输入描述:
 数字N,1<=N<=10^18
 输出描述:
 输出执行多少次操作能把N减到1
 示例1
    输入： 10
    输出： 4
 说明： 10->9-> 3 ->2 ->1
 */
public class Main_1 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        long N = sr.nextLong();
        System.out.println(solution(N));
    }
    //通过率30%
    public static long solution(long N){
        if(N <= 0)
            return 0;
        long count = 0;
        while(N != 1){
            if(Math.sqrt(N) == (long) Math.sqrt(N) ){
                N = (long)Math.sqrt(N);
                count++;
            }else{
                N = N - 1;
                count++;
            }
        }
        return count;
    }
    //通过率100%
    public static void method(long n){
        long temp = n;
        List<Long> list = new ArrayList<>();
        //将 2--N里面所有可以开根号的数存到list里面
        while (temp >1){
            temp = (long) Math.sqrt(temp);
            list.add(temp * temp);
        }
        int count = 0;
        //list里面的坐标索引
        int pos = 0;
        while (n > 1){
            //如果当前数是可以开根号的
            if(n == list.get(pos)){
                ++count;
                //将索引指到下一个数
                ++pos;
                n = (long) Math.sqrt(n);
            }else{
                //中间相差的1的个数
                count += (n-list.get(pos));
                //n变成减去n个1的那个可以开根号的数
                n = list.get(pos);
            }
        }
        System.out.println(count);
    }
}
