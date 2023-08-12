package yunqiu.leetcode.Arrays.����;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**47.ȫ����ii
 * ����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�
 * https://leetcode-cn.com/problems/permutations-ii/
 */
//ִ����ʱ :742 ms, ������ Java �ύ�л�����8.80%���û�
//�ڴ����� :45.7 MB, ������ Java �ύ�л�����44.99%���û�
public class Main_47_ȫ����ii {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backTrace(int[] nums, int start, ArrayList<Integer> tempList, List<List<Integer>> res) {
        //startΪ�߽�ֵ
        if (start == nums.length) {
            if (!res.contains(tempList)) {
                res.add(new ArrayList<>(tempList));
            }
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            tempList.add(nums[start]);
            backTrace(nums, start + 1, tempList, res);
            tempList.remove(tempList.size() - 1);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //������� vis ������Ѿ��������
    static boolean[] vis;

    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        List<List<Integer>> list2 = permuteUnique2(nums);
        System.out.println();
    }
}


