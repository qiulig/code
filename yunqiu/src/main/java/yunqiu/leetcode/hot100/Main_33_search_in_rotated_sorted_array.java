package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 33.������ת��������
 */

public class Main_33_search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int []nums = {1};
        int target = 1;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left =0;
        int right = len-1;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

       while (left<=right){
           int middle = (left+right)/2;
           if(nums[middle] == target){
               return middle;
           }
           //����0~middle����������
           if(nums[0]<=nums[middle]){
               //���target���������������ж��ֲ���
               if(nums[0]<=target && target<nums[middle]){
                   right = middle - 1;
               }else {
                   left = middle + 1;
               }
           }else{
               //����middle��len����������
               if(nums[middle] <target && target <= nums[len-1]){
                   left = middle+1;
               }else{
                   right = middle - 1;
               }

           }
       }
       return -1;
    }
}
