package yunqiu.jianzhi_offer.Array;

import java.util.ArrayList;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main_40_数组中只出现一次的数字 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> res = new ArrayList();
        for(int i = 0;i<array.length;i++){
            if(res.contains(array[i])){
                //这里remove掉的是里面的数array[i]，而不是array[i]索引对应的数
                res.remove(Integer.valueOf(array[i]));

            }else{
                res.add(array[i]);
            }
        }
        num1[0] = res.get(0);
        num2[0] = res.get(1);
    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,1,2,3,4,6};
        int num1[] = new int[1];
        int num2[] = new int[1];
        FindNumsAppearOnce(arr,num1,num2);
    }
}
