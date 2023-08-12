package yunqiu.leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34.�����������в���Ԫ�صĵ�һ�������һ��λ��
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 *
 * ��������в�����Ŀ��ֵ target������?[-1, -1]��
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
                //��start��end������mid
                start = middle;
                end = middle;
                //ֻҪstart��end����߽����������ҵ���targetֵ�������Խ���ѭ��
                while (start >= 0 && nums[start] == target)
                    start--;
                while (end < nums.length && nums[end] == target)
                    end++;
                break;

            }
        }
            //����ѭ������֮��nums[start] != target nums[end] != target��������Ҫstart+1��end-1
        return new int[]{start + 1, end - 1};
    }

}
