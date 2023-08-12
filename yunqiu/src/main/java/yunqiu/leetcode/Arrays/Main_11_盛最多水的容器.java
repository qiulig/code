package yunqiu.leetcode.Arrays;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Main_11_盛最多水的容器 {
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            res = Math.max(res,(right-left)*Math.min(height[left],height[right]));
            //舍弃高度较小的
            if ((height[left] > height[right])) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
