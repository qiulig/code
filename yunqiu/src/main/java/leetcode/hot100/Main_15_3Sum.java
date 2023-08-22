package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
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
        //先进行排序
        Arrays.sort(nums);
        List<Integer> targets = new ArrayList<>(); //用于去重
        List<List<Integer>> ret = new ArrayList<>();
        for (int left = 0; left < nums.length; left++) {
            int target = -1 * nums[left];
            //避免第一个值重复 left
            if (!targets.contains(target)) {
                targets.add(target);
                int middle = left + 1;
                int right = nums.length - 1;
                //二分法进行查找
                while (middle < right) {
                    //如果相等，则加入结果集
                    if (nums[middle] + nums[right] == target) {
                        List temp = new ArrayList(Arrays.asList(nums[left], nums[middle], nums[right]));
                        ret.add(temp);
                        //避免第二个重复值出现middle
                        while (middle < right && nums[middle] == nums[middle + 1]) {
                            middle++;
                        }
                        //避免第三个重复值出现 right
                        while (middle < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        //缩小范围继续查找
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
