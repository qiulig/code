package leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-subarray-with-positive-product/
 * 1567.�˻�Ϊ������������鳤��
 */
public class Main_1567_maximum_length_of_subarray_with_positive_product {
    public static void main(String[] args) {
        int nums[] = {0, 1, -2, -3, -4};
        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        int len = nums.length;
        //���±� i ��β�ĳ˻�Ϊ������������鳤��
        int[] positive = new int[len];
        //���±� i ��β�ĳ˻�Ϊ������������鳤��
        int[] negative = new int[len];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        int maxLen = positive[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                //��������
                positive[i] = positive[i - 1] + 1;
                //�����ø� ����ǰһ��Ϊ0�����൱�ڸ��������num[i]һ��ֵ����num[i]>0,������������Ϊ0
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                //����nums[i]����(negative[i-1])����;��ǰһ��Ϊ0�����൱�ڸ��������num[i]һ��ֵ����num[i]<0,������������Ϊ0
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                //����nums[i]�����ø�
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            maxLen = Math.max(maxLen, positive[i]);
        }
        return maxLen;
    }
}
