package leetcode.hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 31.��һ������
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
            //������ġ���������ǰ��ġ�С��������
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
        //�����������һ����������У��������������г���С�����У����������У���
        //��������˵����ǰ�����ǴӴ�С��ֻ��Ҫ�Գ��滻���ɱ����С����
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
