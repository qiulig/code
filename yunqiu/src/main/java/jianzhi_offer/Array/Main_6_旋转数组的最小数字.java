package jianzhi_offer.Array;

/** 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Main_6_旋转数组的最小数字 {
    public static class Solution {
            public static int minNumberInRotateArray(int[] array){
                int low = 0;
                int high = array.length - 1;
                while(low < high){
                    int middle = low + (high - low)/2;
                    if(array[middle] > array[high]){
                        low = middle + 1;
                    }else if(array[middle] == array[high]){
                        high = high - 1;
                    }else{
                        high = middle;
                    }
                }
                return array[low];
            }
        }

    public static void main(String[] args) {
        int arr[] = {1,1,1,0,1,1};
        int a[] = {1,0,1,1,1};
        int b[] = {3,4,5,1,2};
        System.out.println(Solution.minNumberInRotateArray(arr));
    }
    }
