package yunqiu.jianzhi_offer.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Main_42_和为s的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> ss = new ArrayList<>();
        int Min_ = Integer.MAX_VALUE;
        //index1用于存放比较小的那个数
        int index1 = 0;
        //index1用于存放比较大的那个数
        int index2 = 0;
        for(int i = 0;i<array.length;i++){
            if(res.contains(sum-array[i])){
                if(Min_>(sum-array[i])*array[i]){
                    Min_ = (sum-array[i])*array[i];
                    index1 = array[i];
                    index2 = sum-array[i];
                }
            }else{
                res.add(array[i]);
            }
            if(index1!=0||index2!=0)
            {
                ss.add(index1);
                ss.add(index2);
            }
        }
        return ss;
    }

}
