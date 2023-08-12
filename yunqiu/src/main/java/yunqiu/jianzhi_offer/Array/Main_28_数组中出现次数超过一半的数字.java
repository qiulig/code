package yunqiu.jianzhi_offer.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Main_28_数组中出现次数超过一半的数字 {
    public static class Solution {
        public static int MoreThanHalfNum_Solution(int [] array) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int res = 0;
            for(int i = 0;i<array.length;i++){
                if(map.containsKey(array[i])){
                    map.put(array[i],map.get(array[i])+1);
                }else{
                    map.put(array[i],1);
                }
            }
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                    if(entry.getValue()>array.length/2)
                        res = entry.getKey();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,2,4,2,5,2,3};
        Solution.MoreThanHalfNum_Solution(arr);
    }
}
