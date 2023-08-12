package yunqiu.leetcode.hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42.����ˮ
 */
public class Main_42_trapping_rain_water {
   // ˼·�����������е�ÿ��Ԫ�أ������ҳ������ˮ�ܴﵽ�����λ�ã������������߶ȵĽ�Сֵ��ȥ��ǰ�߶ȵ�ֵ��
   public static void main(String[] args) {
       int []height={0,1,0,2,1,0,1,3,2,1,2,1};
       System.out.println(trap(height));
   }
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int len = height.length;

        int[] leftMaxs = new int[len];
        //��ָ���ʼ��Ϊ��һ����
        leftMaxs[0] = height[0];
        //����ߵ�max [��1---������1����]  leftmax,height
        for (int i = 1; i < len; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], height[i]);
        }
        int[] rightMaxs = new int[len];
        //��ָ���ʼ��Ϊ�������һ����
        rightMaxs[len-1] = height[len-1];
        //���ұߵ�max [�ӵ�����2λ��---0]  height,rightmax
        for (int i = len - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], height[i]);
        }
        int value = 0;
        //���������е�ÿ��Ԫ�أ������ҳ������ˮ�ܴﵽ�����λ�ã������������߶ȵĽ�Сֵ��ȥ��ǰ�߶ȵ�ֵ��
        for (int i = 0; i < len; i++) {
            value += Math.max(0, Math.min(leftMaxs[i], rightMaxs[i]) - height[i]);
        }
        return value;
    }
}
