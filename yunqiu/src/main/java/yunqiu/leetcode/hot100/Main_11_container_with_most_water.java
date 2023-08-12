package yunqiu.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 11.ʢ���ˮ������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����(i,ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i�������˵�ֱ�Ϊ(i,ai) �� (i, 0) ���ҳ����е������ߣ�
 * ʹ��������x�Ṳͬ���ɵ�����������������ˮ��
 *
 * ˵�����㲻����б������

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
