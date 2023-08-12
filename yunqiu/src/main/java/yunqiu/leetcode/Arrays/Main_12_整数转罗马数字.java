package yunqiu.leetcode.Arrays;

/**
 * ����ת��������
 * �������ְ������������ַ���I��V��X��L��C��D��M��
 *
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д��II����Ϊ�������е� 1��12 д��XII����ΪX+II�� 27 д��XXVII, ��ΪXX+V+II��
 *
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��IIII������IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪIX���������Ĺ���ֻ�������������������
 *
 * I���Է���V(5) ��X(10) ����ߣ�����ʾ 4 �� 9��
 * X���Է���L(50) ��C(100) ����ߣ�����ʾ 40 ��90��
 * C���Է���D(500) ��M(1000) ����ߣ�����ʾ400 ��900��
 * ����һ������������תΪ�������֡�
 *
 * ���ӣ�https://leetcode-cn.com/problems/integer-to-roman
 */
public class Main_12_����ת�������� {
    public static String intToRoman(int num) {
        int   arr [] = {1000, 900, 500, 400,100,  90, 50,  40, 10,   9,  5,   4, 1 };
        String str[] = { "M","CM", "D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        StringBuilder res = new StringBuilder("");
        //һ���������������С���ڴ���ұ�
        while(num!=0&& i<arr.length){
            if(num>=arr[i]){
                num  = num-arr[i];
                res.append(str[i]);
            }else{
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
}
