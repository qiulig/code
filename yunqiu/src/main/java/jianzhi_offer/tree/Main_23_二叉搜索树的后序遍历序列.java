package jianzhi_offer.tree;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 2.解题思路
 */
public class Main_23_二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        int len = sequence.length;  //数组长度
        int root = sequence[len - 1];  //数组的最后一个数为根
        int i = 0;
        for (; i < len - 1; i++) {
            if (root <= sequence[i])   //左子树的数值都小于根
                break;
        }
        //此时的j即为划分出来的左子树部分和右子树部分的分界
        int j = i;
        for (; j <= len - 1; j++) {
            //j到len-1都都为右子树，数值都大于root,如果root大于他们，则返回false
            if (root > sequence[j]) {
                return false;
            }
        }
        //递归判断左子树
        boolean leftflag = true;
        if (i > 0) {
            leftflag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));

        }
        //递归判断右子树
        boolean rightflag = true;
        if (i < len - 1) {
            rightflag = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));

        }
        return leftflag && rightflag;
    }


}
