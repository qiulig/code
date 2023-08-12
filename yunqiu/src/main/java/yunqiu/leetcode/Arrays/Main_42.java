package yunqiu.leetcode.Arrays;

import java.util.HashMap;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 思路：对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
 */
public class Main_42 {
    //转化成每个位置留下的水量的总和
    public static int trap1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(arr[l], leftMax);
            }
            for (int r = i + 1; r < arr.length; r++) {
                rightMax = Math.max(arr[r], rightMax);
            }
            value += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return value;
    }

    //思路2：依次结算每个位置的水量，max_left和max_right那边数值小结算哪边。并向中间滑动。
    public static int trap2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        HashMap map = new HashMap<>();
        int n = arr.length - 2;
        int[] leftMaxs = new int[n];
        leftMaxs[0] = arr[0];//左指针初始化为第一个数
        //求左边的max
        for (int i = 1; i < n; i++) {
            leftMaxs[i] = Math.max(leftMaxs[i - 1], arr[i]);
        }
        int[] rightMaxs = new int[n];
        rightMaxs[n - 1] = arr[n + 1];//右指针初始化为数组最后一个数
//求右边的max
        for (int i = n - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
        }
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMaxs[i - 1], rightMaxs[i - 1]) - arr[i]);
        }
        return value;
    }

    //思路3：减少一个指针
    public static int trap3(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int n = arr.length - 2;
        int[] rightMaxs = new int[n];
        rightMaxs[n - 1] = arr[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i + 2]);
        }
        int leftMax = arr[0];
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value += Math.max(0, Math.min(leftMax, rightMaxs[i - 1]) - arr[i]);
            leftMax = Math.max(leftMax, arr[i]);
        }
        return value;
    }
    //思路4：
    public static int trap4(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int l = 1;//从第二个查看是否能蓄水
        int r = arr.length - 2;////从倒数第二个查看是否能蓄水
        while (l <= r) {
            if (leftMax <= rightMax) {
                value += Math.max(0, leftMax - arr[l]);
                leftMax = Math.max(leftMax, arr[l++]);
            } else {
                value += Math.max(0, rightMax - arr[r]);
                rightMax = Math.max(rightMax, arr[r--]);
            }
        }
        return value;
    }
    public static  int trap(int[] height) {
        if(height==null||height.length<3)
            return 0;
        int res = 0;
        int leftMax = height[0];
        int RightMax = height[height.length-1];
        int left = 1;
        int right = height.length-2;
        while(left<=right){
            if(leftMax<RightMax){
                res += Math.max(0,leftMax-height[left]);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }else{
                res += Math.max(0,RightMax-height[right]);
                RightMax = Math.max(RightMax,height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println( trap(arr));
    }
}
