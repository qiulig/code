package jianzhi_offer.Array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 */
public class Main_13_调整数值顺序使奇数位于偶数前面 {
    public static class Solution {
        public static void reOrderArray(int [] array) {
            int []res = new int[array.length];
            int count = 0;
            int count2  = 0;
            for(int i = 0;i<array.length;i++){
                //如果是奇数，则放在数组前面
                if(array[i]%2 != 0){
                    array[count++] = array[i];
                }else{
                    //偶数放在另一个数组里
                    res[count2++] = array[i];
                }
            }
            int j = 0;
            for(int i = count;i<array.length;i++){
                array[i] = res[j++];
            }
        }

        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5};
            reOrderArray(arr);
            for(int i = 0;i<arr.length;i++){
                System.out.print(arr[i]);
            }
        }
    }

}
