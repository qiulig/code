package jianzhi_offer.Array;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������
 * ż����ż��֮������λ�ò��䡣
 */
public class Main_13_������ֵ˳��ʹ����λ��ż��ǰ�� {
    public static class Solution {
        public static void reOrderArray(int [] array) {
            int []res = new int[array.length];
            int count = 0;
            int count2  = 0;
            for(int i = 0;i<array.length;i++){
                //��������������������ǰ��
                if(array[i]%2 != 0){
                    array[count++] = array[i];
                }else{
                    //ż��������һ��������
                    res[count2++] = array[i];
                }
            }
            int j = 0;
            for(int i = count;i<array.length;i++){
                array[i] = res[j++];
            }
        }

        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5};
            reOrderArray(arr);
            for(int i = 0;i<arr.length;i++){
                System.out.print(arr[i]);
            }
        }
    }

}
