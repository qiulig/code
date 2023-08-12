package yunqiu.leetcode.hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42.接雨水
 */
public class Main_42_trapping_rain_water {
   // 思路：对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
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
        //左指针初始化为第一个数
        leftMaxs[0] = height[0];
        //求左边的max [从1---倒数第1个数]  leftmax,height
        for (int i = 1; i < len; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], height[i]);
        }
        int[] rightMaxs = new int[len];
        //右指针初始化为数组最后一个数
        rightMaxs[len-1] = height[len-1];
        //求右边的max [从倒数第2位到---0]  height,rightmax
        for (int i = len - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], height[i]);
        }
        int value = 0;
        //对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
        for (int i = 0; i < len; i++) {
            value += Math.max(0, Math.min(leftMaxs[i], rightMaxs[i]) - height[i]);
        }
        return value;
    }
}
