package yunqiu.leetcode.hot100;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Main_4_median_of_two_sorted_arrays {
    public static void main(String[] args) {
        int nums1[] = {0,0};
        int nums2[] = {0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1的索引
        int aStart = 0;
        //nums2的索引
        int bStart = 0;
        //中位数的左边一位（前一位）
        int left = 0;
        //中位数的右边一位（后一位）
        int right = 0;
        int len = nums1.length+nums2.length;
        for (int i= 0;i<=len/2;i++){
            //前一位=上次计算的后一位
            left = right;
            //计算当前位
            if(aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else{
                right = nums2[bStart++];
            }
        }
        //长度为偶数时的中位数结果。2.0是为了变成double类型
        if(len%2==0){
            return (left+right)/2.0;
        }else{
            return right;
        }
    }
}
