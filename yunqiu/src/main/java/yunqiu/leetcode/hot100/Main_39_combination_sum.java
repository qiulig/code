package yunqiu.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39.�������
 * ����һ�����ظ�Ԫ�ص�����������candidates��һ��������target���ҳ�candidates�����п���ʹ���ֺ�ΪĿ����target��Ψһ��ϡ�
 *
 * candidates�е����ֿ����������ظ���ѡȡ���������һ����ѡ����������ͬ�������������Ψһ�ġ�
 *
 * ���ڸ��������룬��֤��Ϊtarget ��Ψһ��������� 150 ����

 */
public class Main_39_combination_sum {
    public static void main(String[] args) {
        int []candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);
        System.out.println();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        //����
        Arrays.sort(candidates);
        backTrace(ret,new ArrayList<>(),0,candidates,target);
        return ret;
    }

    private static void backTrace(List<List<Integer>> ret, ArrayList<Integer> temp, int start, int[] candidates, int target) {
        if(target == 0){
            ret.add(new ArrayList<>(temp));
        }else {
            //����������򣬲�Ȼ������&&�ж�
            for(int i = start;i<candidates.length  && target >= candidates[i];i++){
                temp.add(candidates[i]);
                //������Ϊ���ظ�ѡ�������´λ��ݻ������ٴ�ѡ��ǰ��������������i
                backTrace(ret,temp,i,candidates,target-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
