package leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 31.下一个排列
 */
public class Main_31_next_permutation {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int right = nums.length - 1;
        int left = right - 1;
        int flag = 0;
        while (right != 0) {
            //将后面的「大数」与前面的「小数」交换
            if (nums[right] > nums[left]) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                flag = 1;
                System.out.println(Arrays.toString(nums));
                return;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right--;
                    left = right - 1;
                }
            }
        }
        //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
        //不存在则说明当前排序是从大到小，只需要对称替换即可变成最小的数
        if (flag == 0) {
            int temp = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
