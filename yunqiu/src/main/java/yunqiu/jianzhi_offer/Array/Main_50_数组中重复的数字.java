package yunqiu.jianzhi_offer.Array;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class Main_50_数组中重复的数字 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    //桶排序方法
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0)
            return true;
        int res[] = new int [length];
        boolean flag = false;
        for(int i = 0;i<length;i++){
           res[numbers[i]]++;
            //有重复的数
            if(res[numbers[i]]>1){
                duplication[0] = numbers[i];
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,2,1,4};
        int[] dup = new int [1];
        duplicate(arr,arr.length,dup);
    }
}
