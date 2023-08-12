package yunqiu.leetcode.Arrays.����;

import java.util.ArrayList;
import java.util.List;
//ִ����ʱ :41 ms, ������ Java �ύ�л�����5.01%���û�
//�ڴ����� :44.4 MB, ������ Java �ύ�л�����5.03%���û�

/**
 * 46.ȫ����
 *  https://leetcode-cn.com/problems/permutations/
 * ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
 * ���룺nums = [1,2,3]
 * �����[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Main_46_ȫ���� {
    public static void main(String[] args) {
        int [] arr = {1,2,1};
        permute(arr);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums,0,new ArrayList<>(),res);
        return res;
    }

    private static void backTrace(int[] nums, int start,ArrayList<Integer> tempList, List<List<Integer>> res) {
        //startΪ�߽�ֵ
        if(start == nums.length){
            if(!res.contains(tempList)){
                res.add(new ArrayList<>(tempList));
            }
        }
        for(int i = start;i<nums.length;i++){
            swap(nums,start,i);
            tempList.add(nums[start]);
            backTrace(nums,start+1,tempList,res);
            tempList.remove(tempList.size()-1);
            swap(nums,start,i);
        }
    }

    private static void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
