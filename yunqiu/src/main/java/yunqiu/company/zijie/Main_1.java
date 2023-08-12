package yunqiu.company.zijie;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
题目：一个小球，从高H的地方落下，落下弹起高度为H/2,如此往复，计算小球从H高度落下到第n次弹起的往返路程
  输入描述：
    输入第一行为样例数m,接下来m行每行2个整数H和n,n不超过5
  输出描述：
    输出m行，表示总路程，结果保留小数点后2位
  例：
     输入：
        1
        5
        2
     输出：
        10.00
 */
public class Main_1 {
    public static double solution(int Height,int n){
        if(n==0)
            return 0;
        if(n == 1)
            return Height;
        double res = Height;
        double H = Height*1.00/2;
        for(int i = 1;i<n;i++){
            res = res + H*2;
            H = H/2;
        }
        return res;
//        return res%.2f;
    }
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int m = sr.nextInt();
        int height[]  = new int[m];
        int n[] = new int[m];
        for(int i = 0;i<m;i++) {
             height[i] = sr.nextInt();
             n[i] = sr.nextInt();
        }
        for(int i = 0;i<m;i++){
            System.out.println(df.format(solution(height[i],n[i])));
//            System.out.println(solution(height[i],n[i]));
        }
    }
}
