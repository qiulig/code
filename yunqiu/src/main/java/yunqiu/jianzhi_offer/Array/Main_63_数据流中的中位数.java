package yunqiu.jianzhi_offer.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * �������е���λ��
 * ��εõ�һ���������е���λ����������������ж�����������ֵ
 * ��ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ��
 * ��ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ��������
 * ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 */
public class Main_63_�������е���λ�� {
    public class Solution {
       ArrayList<Integer> list = new ArrayList<>();
        public void Insert(Integer num) {
            list.add(num);

        }
        public Double GetMedian() {
            int size = list.size();
            if(size!=0){
                Collections.sort(list);
                if(size%2==0){
                    return (list.get(size/2)+list.get(size/2-1))/2.0;
                }else {
                    return list.get(size/2)*1.0;
                }
            }else {
                return null;
            }
        }
    }
}
