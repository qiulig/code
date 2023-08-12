package yunqiu.leetcode.Arrays;

/**给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *示例:
 *输入: [1,2,3,4]
 *输出: [24,12,8,6]
 *
 */
public class Main_238 {
    public static int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        //此步相当于做了右边的运算
        res[res.length-1] =1;
        for(int i =res.length-2;i>=0;i--){
            res[i] = res[i+1]*nums[i+1];
        }
        //此步为左边运算*res[i]得结果
        int left = 1;
        for(int i = 0;i<res.length;i++){
            res[i] = left *res[i];
            left = left*nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int arr []= {1,2,3,4};
        int res[] = productExceptSelf(arr);
        for(int s:res){
            System.out.print(s+" ");
        }
    }

}
