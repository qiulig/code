package yunqiu.leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34.在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回?[-1, -1]。
 */
public class Main_34_find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        int []nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (nums.length-1)/2;
        int start = -2;
        int end = 0;

        while (left<=right) {
            middle = (left + right) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else {
                //令start和end都等于mid
                start = middle;
                end = middle;
                //只要start和end满足边界条件，并且等于target值，都可以进行循环
                while (start >= 0 && nums[start] == target)
                    start--;
                while (end < nums.length && nums[end] == target)
                    end++;
                break;

            }
        }
            //由于循环出来之后nums[start] != target nums[end] != target，所以需要start+1，end-1
        return new int[]{start + 1, end - 1};
    }

}
