package yunqiu.jianzhi_offer.Array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323��
 */
public class Main_32_�������ų���С���� {
    public static void main(String[] args) {
        int numbers []= {3334,3,3333332};
        PrintMinNumber(numbers);
    }
    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length<=0||numbers == null)
            return "";
        //���򣬿ɵõ�������Ϊnumbers[len-1]
        Arrays.sort(numbers);
        //��λ��
        int count = 0;
        int Max_ = numbers[numbers.length-1];
        //�õ���������λ��
        while(Max_>0) {
            count++;
            Max_ = Max_/10;
        }
        //���������ַ�������
        String str[] = new String[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            str[i] = ""+numbers[i];
        }
        //��λ
        for(int i = 0;i<numbers.length;i++){
            //�õ���λҪ������
            String tmp ="" +str[i].charAt(str[i].length()-1);
            //ԭ�����λ��
            int len =str[i].length();
            //���㵽��ͬ��λ��
            for(int j = 0;j<count-len;j++)
            {
                str[i] = str[i]+tmp;
            }
        }
        //����
        ArrayList<Integer> ss= new ArrayList<>();
        //�������������Ӧ��numbers������
        String strcopy[] = str.clone();
        //������д�С���������
        Arrays.sort(str);
        //�õ���С���������ԭ�������ڵ�����
        for(int i = 0;i<numbers.length;i++){
            for(int j = 0;j<numbers.length;j++){
                if(str[i].equals(strcopy[j])){
                    ss.add(j);
                }
            }
        }
        //����������ƴ�ӵõ����
        String res = "";
        for(int i = 0;i<numbers.length;i++){
            res = res +numbers[ss.get(i)];
        }
        return res;
    }
}
