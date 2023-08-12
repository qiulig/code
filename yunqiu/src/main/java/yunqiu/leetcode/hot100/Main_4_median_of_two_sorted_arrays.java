package yunqiu.leetcode.hot100;

/**
 * 4. Ѱ�����������������λ��
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 */
public class Main_4_median_of_two_sorted_arrays {
    public static void main(String[] args) {
        int nums1[] = {0,0};
        int nums2[] = {0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1������
        int aStart = 0;
        //nums2������
        int bStart = 0;
        //��λ�������һλ��ǰһλ��
        int left = 0;
        //��λ�����ұ�һλ����һλ��
        int right = 0;
        int len = nums1.length+nums2.length;
        for (int i= 0;i<=len/2;i++){
            //ǰһλ=�ϴμ���ĺ�һλ
            left = right;
            //���㵱ǰλ
            if(aStart < nums1.length && (bStart >= nums2.length || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else{
                right = nums2[bStart++];
            }
        }
        //����Ϊż��ʱ����λ�������2.0��Ϊ�˱��double����
        if(len%2==0){
            return (left+right)/2.0;
        }else{
            return right;
        }
    }
}
