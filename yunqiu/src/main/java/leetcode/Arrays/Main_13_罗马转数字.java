package leetcode.Arrays;

import java.util.HashMap;

/**
 * ����ת����
 * �������ְ������������ַ�:I��V��X��L��C��D��M��
 * <p>
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д��II����Ϊ�������е� 1��12 д��XII����ΪX+II�� 27 д��XXVII, ��ΪXX+V+II��
 * <p>
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��IIII������IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪIX���������Ĺ���ֻ�������������������
 * <p>
 * I���Է���V(5) ��X(10) ����ߣ�����ʾ 4 �� 9��
 * X���Է���L(50) ��C(100) ����ߣ�����ʾ 40 ��90��
 * C���Է���D(500) ��M(1000) ����ߣ�����ʾ400 ��900��
 * ����һ���������֣�����ת��������������ȷ���� 1�� 3999 �ķ�Χ�ڡ�
 * ���ӣ�https://leetcode-cn.com/problems/roman-to-integer
 */
public class Main_13_����ת���� {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 1; i > 0; i--) {
            //���������д��������С�����ֵ��ұߣ��ü���
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                res -= map.get(s.charAt(i - 1));
            } else {
                //����������С�������ڴ�����ֵ��ұߣ��üӷ�
                res += map.get(s.charAt(i - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
