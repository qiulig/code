package yunqiu.leetcode.Arrays;

import java.util.PriorityQueue;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2
 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 你可以假设 nums1 和 nums2 不会同时为空。
 示例 1:
 nums1 = [1, 3]
 nums2 = [2]
 则中位数是 2.0
 示例 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 */
public class Main_4_寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aStart = 0;
        int bStart = 0;
        int left = 0;
        int right = 0;
        int len = nums1.length+nums2.length;
        for (int i= 0;i<=len/2;i++){
            left = right;
            if(aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else{
                right = nums2[bStart++];
            }
        }
        if(len%2==0){
            return (left+right)/2.0;
        }else{
            return right;
        }
    }
    public static void main(String[] args) {
        int a[] = {};
        int b[] = {3,5};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
