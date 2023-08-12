package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11.盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。

 */
public class Main_11_container_with_most_water {
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int width = right -  left;
        int ret = 0;
        while (left<=right){
            if(height[left]<height[right]){
                ret = Math.max(ret,height[left++] * width);
                width = right-left;
            }else {
                ret = Math.max(ret,height[right--] * width);
                width = right-left;
            }
        }
        return ret;
    }
}
