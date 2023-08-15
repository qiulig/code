package Year2023;

import java.util.*;

/**
 * Created by qiulig on 2023/8/15
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class Main_15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(list -> {
            System.out.println(list);
        });

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        // 升序排序
        Arrays.sort(nums);
        // 用于存储记录过的target值
        Set<Integer> targetSet = new HashSet<>();
        for (int index = 0; index <= nums.length - 2; index++) {
            // 依次固定target
            int target = -1 * nums[index];
            // target记录过则直接跳过
            if (targetSet.contains(target)) {
                continue;
            } else {
                targetSet.add(target);
            }
            // 滑动窗口获取值
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    results.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    // 避免相同的值
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    // 再次缩短范围， 可能还有满足的值
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }
}
