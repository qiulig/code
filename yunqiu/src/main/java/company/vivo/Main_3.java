package company.vivo;

import java.util.*;

/**
 *礼品采购，每款礼品的受欢迎程度不一样，现给出总金额以及各礼品的单价和热度值，且每个礼品只采购一个，如何购买可以使所有礼品总热度值最高
 * 第一行输入正整数，表示总金额
 * 第二行是一个长度为n的正整数数组，表示礼品单价
 * 第三行是一个长度为n的正整数数组，表示对应礼品热度值
 * 输出：
 * 最高总热度值
 * 例：
 * 输入：
 * * 1000
 * * 200 600 100 180 300 450
 * * 6   10   3   4   5   8
 * 输出：
 * * 21
 *
 */
public class Main_3 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(9);
        while (!set.isEmpty()){
            System.out.println(set.pollFirst());
        }
        int total = 1000;
        int []f = new int[total+1];
        int weight[] = {200 ,600, 100, 180, 300, 450};
        int value[] = {6  , 10,   3,   4,   5,   8};
        //三个不能同时调试，会出错
        //0-1背包
//        System.out.println(ZeroOnePackage(weight,value,f,weight.length,total));
       //完全背包
//        System.out.println(ZeroMorePackage(weight,value,f,weight.length,total));
       //多重背包
        int eachNum[] = {2,3,2,1,3,5};
//        System.out.println(MorePackage(weight,value,f,weight.length,total,eachNum));

        //vivo题
        solution(total,weight,value);
    }
    //情况1：第i件不放进去，所得价值f[v]
    //情况2：第i件放进去，所得价值[v-c[i]]+w[i]
    //状态转移方程：f[v] = max(f[v],f[v-w[i]]+c[i])
    //weight表示每件物品的重量，value代表每件物品的价值，total 表示容量，Num表示物品数量，
    // 设 f[v]表示重量不超过v公斤的最大价值，
    //0-1背包
    public static int ZeroOnePackage(int []weight,int []value,int []f,int Num,int total){
        for(int i = 0;i<Num;i++){
            for(int v = total;v>=weight[i];v--){ //注意是逆序
                f[v] = Math.max(f[v-weight[i]]+value[i],f[v]);
            }
        }
        return f[total];
    }
    //完全背包
    public static int ZeroMorePackage(int []weight,int []value,int []f,int Num,int total){
        for(int i = 0;i<Num;i++){
            for(int v = weight[i];v<=total;v++){ //注意是逆序
                f[v] = Math.max(f[v-weight[i]]+value[i],f[v]);
            }
        }
        return f[total];
    }
    //多重背包问题
    public static int MorePackage(int []weight,int []value,int []f,int Num,int total,int eachNum[]){
        for(int i = 0;i<Num;i++) {
            for (int v = total; v >= 0; v--) { //注意是逆序
                for (int k = 0; k <= eachNum[i]; k++) {
                    if (v - k * weight[i] < 0) {
                        break;
                    }else{
                        f[v] = Math.max(f[v - k * weight[i]] + k * value[i], f[v]);
                    }
                }
            }
        }
            return f[total];
    }
    //vivo第三题代码
    //arrA代表重量weight[]，arrB代表价值value[]
    public static void solution(int total,int []arrA,int []arrB){
        int [] f = new int[total+1];
        System.out.println(ZeroPackage(arrA,arrB,f,arrA.length,total));
    }

    private static int ZeroPackage(int[] weight, int[] value, int[] f, int Num, int total) {
        for(int i = 0;i<Num ; i++){
            for(int v = total;v>=weight[i];v--){
                f[v] = Math.max(f[v],f[v-weight[i]]+value[i]);
            }
        }
        return f[total];
    }

}
