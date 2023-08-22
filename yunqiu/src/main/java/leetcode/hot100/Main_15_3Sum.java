package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * ����֮��
 * ����һ������ n ������������nums���ж�nums���Ƿ��������Ԫ�� a��b��c ��ʹ��a + b + c = 0 �������ҳ����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 * <p>
 * ע�⣺���в����԰����ظ�����Ԫ�顣
 */
public class Main_15_3Sum {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        for (List t : lists) {
            t.forEach(System.out::print);
            System.out.println();
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //�Ƚ�������
        Arrays.sort(nums);
        List<Integer> targets = new ArrayList<>(); //����ȥ��
        List<List<Integer>> ret = new ArrayList<>();
        for (int left = 0; left < nums.length; left++) {
            int target = -1 * nums[left];
            //�����һ��ֵ�ظ� left
            if (!targets.contains(target)) {
                targets.add(target);
                int middle = left + 1;
                int right = nums.length - 1;
                //���ַ����в���
                while (middle < right) {
                    //�����ȣ����������
                    if (nums[middle] + nums[right] == target) {
                        List temp = new ArrayList(Arrays.asList(nums[left], nums[middle], nums[right]));
                        ret.add(temp);
                        //����ڶ����ظ�ֵ����middle
                        while (middle < right && nums[middle] == nums[middle + 1]) {
                            middle++;
                        }
                        //����������ظ�ֵ���� right
                        while (middle < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //��С��Χ��������
                        middle++;
                        right--;
                    } else if (nums[middle] + nums[right] < target) {
                        middle++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return ret;
    }
}
