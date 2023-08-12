package yunqiu.jianzhi_offer.Array;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Main_29_最小的K个数 {
    public static void main(String[] args) {
        int input[] = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(input,4);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length<k)
            return res;
        quicksort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
    public static void quicksort(int arr[], int low, int high)
    {
        if(low < high)
        {
            int position = partition(arr, low, high);
            quicksort(arr, low, position - 1);
            quicksort(arr, position + 1, high);
        }

    }
        public static int partition(int arr[], int low, int high) {
            //设置基准值
            int key = arr[low];
            while(low < high){
                //从右到左，直到找到一个小于key的值
                while(low < high && arr[high] >= key) --high;
                //将该值填入前的坑
                arr[low] = arr[high];
                //从左到右，直到找到一个大于key的值
                while(low < high && arr[low] <= key) ++low;
                //将该值填入前一个坑
                arr[high] = arr[low];
            }
            //将基准值填入最后一个坑
            arr[low] = key;
            //最后一个坑划分了左边小于该值，右边大于该值
            return low;
        }
    }
