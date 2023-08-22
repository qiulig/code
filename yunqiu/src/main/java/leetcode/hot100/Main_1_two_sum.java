package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
/*
https://leetcode-cn.com/problems/two-sum/
����֮��
����һ���������� nums?��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target? ����?����?���������������ǵ������±ꡣ
  ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
   ����԰�����˳�򷵻ش𰸡�
*/

public class Main_1_two_sum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
            } else {
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
        }
        return res;
    }
}
