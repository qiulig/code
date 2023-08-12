package yunqiu.suanfa;

import java.util.TreeSet;

public class Main_背包问题 {
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

    }

}
