package yunqiu.leetcode.Arrays;

import java.util.PriorityQueue;

/**
 * ����������СΪ m �� n ���������� nums1 �� nums2
 �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
 ����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
 ʾ�� 1:
 nums1 = [1, 3]
 nums2 = [2]
 ����λ���� 2.0
 ʾ�� 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 ����λ���� (2 + 3)/2 = 2.5

 */
public class Main_4_Ѱ�����������������λ�� {
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
