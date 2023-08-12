package jianzhi_offer.tree;

import java.util.Arrays;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No��
 * �������������������������ֶ�������ͬ��
 * 2.����˼·
 */
public class Main_23_�����������ĺ���������� {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int len = sequence.length;  //���鳤��
        int root = sequence[len - 1];  //��������һ����Ϊ��
        int i = 0;
        for (; i < len - 1; i++) {
            if (root <= sequence[i])   //����������ֵ��С�ڸ�
                break;
        }
        //��ʱ��j��Ϊ���ֳ��������������ֺ����������ֵķֽ�
        int j = i;
        for (; j <= len - 1; j++) {
            //j��len-1����Ϊ����������ֵ������root,���root�������ǣ��򷵻�false
            if (root > sequence[j]) {
                return false;
            }
        }
        //�ݹ��ж�������
        boolean leftflag = true;
        if (i > 0) {
            leftflag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));

        }
        //�ݹ��ж�������
        boolean rightflag = true;
        if (i < len - 1) {
            rightflag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));

        }
        return leftflag && rightflag;
    }


}
