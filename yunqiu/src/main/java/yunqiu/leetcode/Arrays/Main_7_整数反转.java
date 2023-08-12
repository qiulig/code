package yunqiu.leetcode.Arrays;
/**
 * ����һ�� 32 λ���з������� x �����ؽ� x �е����ֲ��ַ�ת��Ľ����
 *
 *         �����ת���������� 32 λ���з��������ķ�Χ?[?231,? 231?? 1] ���ͷ��� 0��
 *
 *         ���軷��������洢 64 λ�������з��Ż��޷��ţ���
 *
 *         ��Դ�����ۣ�LeetCode��
 *         ���ӣ�https://leetcode-cn.com/problems/reverse-integer
 *         ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Main_7_������ת {
    public static int reverse(int x) {
        int res = 0;
        while (x!=0){
            //�õ����һλ
            int pop = x%10;
            //�õ�ǰ��λ
            x = x/10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                res = 0;
                break;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                res = 0;
                break;
            }
            res = res*10 + pop;

        }
        return res;
    }
        public static void main(String[] args) {
            System.out.println(reverse(-1234));
        }
}
