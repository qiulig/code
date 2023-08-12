package yunqiu.leetcode.Arrays;

import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateReplyMessage_1_0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        int len = triangle.get(triangle.size()-1).size();
        int dp[][] = new int[len][len];
        //初始化第一层跟第二层
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = dp[0][0]+triangle.get(1).get(0);
        dp[1][1] = dp[0][0] + triangle.get(1).get(1);
        //第一列初始化
        for(int i = 2;i < len;i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
        for(int i = 2;i<len;i++){
            for(int j = 1;j<= i ;j++){
                //最后一个数的dp,因为上一层比下一层少一个，所以只能最后一个数只能加上上一层的最后一个dp
                if(j == i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle.get(i).get(j)+ Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        //三角形最后一层中的最小值就是最小路径
        int res = dp[len-1][0];
        for(int i = 1;i<len;i++){
            if(dp[len-1][i] < res){
                res = dp[len-1][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
//          List<Integer> l1 = new ArrayList<>();
//          l1.add(-1);
//          List<Integer> l2 = new ArrayList<>();
//          l2.add(2);
//          l2.add(3);
//          List<Integer> l3 = new ArrayList<>();
//          l3.add(1);
//          l3.add(-1);
//          l3.add(-3);
//          List<List<Integer>> list = new ArrayList<>();
//          list.add(l1);
//          list.add(l2);
//          list.add(l3);
          System.out.println(minimumTotal(list));
    }
}
